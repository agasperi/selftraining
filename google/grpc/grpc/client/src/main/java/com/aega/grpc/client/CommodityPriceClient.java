package com.aega.grpc.client;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.google.protobuf.Any;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.rpc.Code;
import com.google.rpc.ErrorInfo;
import io.grpc.Channel;
import io.grpc.Metadata;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import io.grpc.protobuf.ProtoUtils;
import io.grpc.protobuf.StatusProto;
import io.grpc.stub.StreamObserver;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import lombok.extern.slf4j.Slf4j;
import org.baeldung.grpc.Commodity;
import org.baeldung.grpc.CommodityPriceProviderGrpc;
import org.baeldung.grpc.CommodityQuote;
import org.baeldung.grpc.ErrorResponse;
import org.baeldung.grpc.CommodityPriceProviderGrpc.CommodityPriceProviderBlockingStub;
import org.baeldung.grpc.CommodityPriceProviderGrpc.CommodityPriceProviderStub;
import org.baeldung.grpc.StreamingCommodityQuote;
import org.junit.jupiter.api.Assertions;


@Slf4j
public class CommodityPriceClient {

    private CommodityPriceProviderBlockingStub blockingStub;
    private CommodityPriceProviderStub nonBlockingStub;

    public CommodityPriceClient(Channel channel) {
        blockingStub = CommodityPriceProviderGrpc.newBlockingStub(channel);
        nonBlockingStub = CommodityPriceProviderGrpc.newStub(channel);
    }

    public void getBestCommodityPrice() {
        log.info("***** Commodity Price Example *****: getBestCommodityPrice");

        // whenUsingInvalidCommodityName_thenReturnExceptionIoRpcStatus
        Commodity request1 = Commodity.newBuilder()
            .setAccessToken("123validToken")
            .setCommodityName("Commodity5")
            .build();

        StatusRuntimeException thrown = Assertions.assertThrows(StatusRuntimeException.class
                , () -> blockingStub.getBestCommodityPrice(request1));

        assertEquals("INVALID_ARGUMENT", thrown.getStatus().getCode().toString());
        assertEquals("INVALID_ARGUMENT: The commodity is not supported", thrown.getMessage());
        Metadata metadata = Status.trailersFromThrowable(thrown);
        ErrorResponse errorResponse = metadata.get(ProtoUtils.keyForProto(ErrorResponse.getDefaultInstance()));
        assertEquals("Commodity5",errorResponse.getCommodityName());
        assertEquals("123validToken", errorResponse.getAccessToken());
        assertEquals("Only Commodity1, Commodity2 are supported", errorResponse.getExpectedValue());

        // whenUsingInvalidRequestToken_thenReturnExceptionGoogleRPCStatus()
        Commodity request2 = Commodity.newBuilder()
            .setAccessToken("invalidToken")
            .setCommodityName("Commodity1")
            .build();

        thrown = Assertions.assertThrows(StatusRuntimeException.class
                , () -> blockingStub.getBestCommodityPrice(request2));

        com.google.rpc.Status status = StatusProto.fromThrowable(thrown);
        assertNotNull(status);
        assertEquals("NOT_FOUND", Code.forNumber(status.getCode()).toString());
        assertEquals("The access token not found", status.getMessage());

        for (Any any : status.getDetailsList()) {
            if (any.is(ErrorInfo.class)) {
                ErrorInfo errorInfo;
                try {
                    errorInfo = any.unpack(ErrorInfo.class);
                    assertEquals("Invalid Token", errorInfo.getReason());
                    assertEquals("com.baeldung.grpc.errorhandling", errorInfo.getDomain());
                    assertEquals("123validToken", errorInfo.getMetadataMap().get("insertToken"));
                } catch (InvalidProtocolBufferException e) {
                    log.error("Some was wrong! See the stack trace:", e);
                }
            }
        }
    }

    public void getBidirectionalCommodityPriceLists() throws InterruptedException {
        log.info("#######START EXAMPLE#######: BidirectionalStreaming - getCommodityPriceLists from list of commodities");
        final CountDownLatch finishLatch = new CountDownLatch(1);

        StreamObserver<StreamingCommodityQuote> responseObserver = new StreamObserver<StreamingCommodityQuote>() {
            @Override
            public void onNext(StreamingCommodityQuote streamingCommodityQuote) {
                switch (streamingCommodityQuote.getMessageCase()) {
                case COMODITY_QUOTE:
                    CommodityQuote commodityQuote = streamingCommodityQuote.getComodityQuote();
                    log.info("RESPONSE producer:" + commodityQuote.getCommodityName() + " price:" + commodityQuote.getPrice());
                    break;
                case STATUS:
                    com.google.rpc.Status status = streamingCommodityQuote.getStatus();
                    log.info("RESPONSE status error:");
                    log.info("Status code:" + Code.forNumber(status.getCode()));
                    log.info("Status message:" + status.getMessage());
                    for (Any any : status.getDetailsList()) {
                        if (any.is(ErrorInfo.class)) {
                            ErrorInfo errorInfo;
                            try {
                                errorInfo = any.unpack(ErrorInfo.class);
                                log.info("Reason:" + errorInfo.getReason());
                                log.info("Domain:" + errorInfo.getDomain());
                                log.info("Insert Token:" + errorInfo.getMetadataMap()
                                    .get("insertToken"));
                            } catch (InvalidProtocolBufferException e) {
                                log.error(e.getMessage());
                            }
                        }
                    }
                    break;
                default:
                    log.info("Unknow message case");
                }
            }

            @Override
            public void onCompleted() {
                log.info("Finished getBidirectionalCommodityPriceLists");
                finishLatch.countDown();
            }

            @Override
            public void onError(Throwable t) {
                log.error("getBidirectionalCommodityPriceLists Failed:" + Status.fromThrowable(t));
                finishLatch.countDown();
            }
        };

        StreamObserver<Commodity> requestObserver = nonBlockingStub.bidirectionalListOfPrices(responseObserver);
        try {
            for (int i = 1; i <= 2; i++) {
                Commodity request = Commodity.newBuilder()
                    .setCommodityName("Commodity" + i)
                    .setAccessToken(i + "23validToken")
                    .build();
                log.info("REQUEST - commodity:" + request.getCommodityName());
                requestObserver.onNext(request);
                Thread.sleep(200);
                if (finishLatch.getCount() == 0) {
                    return;
                }
            }
        } catch (RuntimeException e) {
            requestObserver.onError(e);
            throw e;
        }
        requestObserver.onCompleted();

        if (!finishLatch.await(1, TimeUnit.MINUTES)) {
            log.info("getBidirectionalCommodityPriceLists can not finish within 1 minute");
        }
    }
}
