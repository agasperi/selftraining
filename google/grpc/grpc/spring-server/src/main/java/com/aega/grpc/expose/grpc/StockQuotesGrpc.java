package com.aega.grpc.expose.grpc;

import com.aega.grpc.proto.Stock;
import com.aega.grpc.proto.StockQuote;
import com.aega.grpc.proto.StockQuoteProviderGrpc.StockQuoteProviderImplBase;
import com.aega.grpc.service.StockQuotesService;
import io.grpc.stub.StreamObserver;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.server.service.GrpcService;


@Slf4j
@GrpcService
@RequiredArgsConstructor
public class StockQuotesGrpc extends StockQuoteProviderImplBase {

    private final StockQuotesService service;

    @Override
    public StreamObserver<Stock> bidirectionalStreamingGetListsStockQuotes(
            StreamObserver<StockQuote> responseObserver) {
        return new StreamObserver<Stock>() {
            @Override
            public void onNext(Stock value) {
                service.getListStockQuotes(value)
                    .forEach(responseObserver::onNext);
            }

            @Override
            public void onError(Throwable t) {
                log.error("error:{}", t.getMessage());
            }

            @Override
            public void onCompleted() {
                responseObserver.onCompleted();
            }
        };
    }

    @Override
    public StreamObserver<Stock> clientSideStreamingGetStatisticsOfStocks(StreamObserver<StockQuote> responseObserver) {
        return new StreamObserver<Stock>() {
            @Override
            public void onNext(Stock value) {
                service.addStatisticsOfStock(value);
            }

            @Override
            public void onError(Throwable t) {
                log.error("error:{}", t.getMessage());
            }

            @Override
            public void onCompleted() {
                responseObserver.onNext(service.getStatitics());
                responseObserver.onCompleted();
            }
        };
    }

    @Override
    public void serverSideStreamingGetListStockQuotes(Stock request, StreamObserver<StockQuote> responseObserver) {
        service.getListStockQuotes(request)
            .forEach(responseObserver::onNext);
        responseObserver.onCompleted();
    }

}
