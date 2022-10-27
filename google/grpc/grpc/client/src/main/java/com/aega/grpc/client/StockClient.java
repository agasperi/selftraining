package com.aega.grpc.client;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import org.baeldung.grpc.Stock;
import org.baeldung.grpc.StockQuote;
import org.baeldung.grpc.StockQuoteProviderGrpc;
import org.baeldung.grpc.StockQuoteProviderGrpc.StockQuoteProviderBlockingStub;
import org.baeldung.grpc.StockQuoteProviderGrpc.StockQuoteProviderStub;

import io.grpc.Channel;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;


@Slf4j
public class StockClient {

    private StockQuoteProviderBlockingStub blockingStub;
    private StockQuoteProviderStub nonBlockingStub;
    private List<Stock> stocks;

    public StockClient(Channel channel) {
        blockingStub = StockQuoteProviderGrpc.newBlockingStub(channel);
        nonBlockingStub = StockQuoteProviderGrpc.newStub(channel);
        initializeStocks();
    }

    public void serverSideStreamingListOfStockPrices() {
        log.info("######START EXAMPLE######: ServerSideStreaming - list of Stock prices from a given stock");
        Stock request = Stock.newBuilder()
            .setTickerSymbol("AU")
            .setCompanyName("Austich")
            .setDescription("server streaming example")
            .build();
        Iterator<StockQuote> stockQuotes;
        try {
            log.info("REQUEST - ticker symbol: {}", request.getTickerSymbol());
            stockQuotes = blockingStub.serverSideStreamingGetListStockQuotes(request);
            for (int i = 1; stockQuotes.hasNext(); i++) {
                StockQuote stockQuote = stockQuotes.next();
                log.info("RESPONSE - Price #{}: {}", i, stockQuote.getPrice());
            }
        } catch (StatusRuntimeException e) {
            log.error("RPC failed: {}", e.getStatus());
        }
    }

    public void clientSideStreamingGetStatisticsOfStocks() throws InterruptedException {
        log.info("######START EXAMPLE######: ClientSideStreaming - getStatisticsOfStocks from a list of stocks");
        final CountDownLatch finishLatch = new CountDownLatch(1);

        StreamObserver<StockQuote> responseObserver = new StreamObserver<StockQuote>() {
            @Override
            public void onNext(StockQuote summary) {
                log.info("RESPONSE, got stock statistics - Average Price: {}, description: {}", summary.getPrice(), summary.getDescription());
            }
    
            @Override
            public void onCompleted() {
                log.info("Finished clientSideStreamingGetStatisticsOfStocks");
                finishLatch.countDown();
            }

            @Override
            public void onError(Throwable t) {
                log.error("Stock Statistics Failed: {}", Status.fromThrowable(t));
                finishLatch.countDown();
            }
        };
        
        StreamObserver<Stock> requestObserver = nonBlockingStub.clientSideStreamingGetStatisticsOfStocks(responseObserver);
        try {
            for (Stock stock : stocks) {
                log.info("REQUEST: {}, {}", stock.getTickerSymbol(), stock.getCompanyName());
                requestObserver.onNext(stock);
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
            log.warn("clientSideStreamingGetStatisticsOfStocks can not finish within 1 minutes");
        }
    }

    public void bidirectionalStreamingGetListsStockQuotes() throws InterruptedException{
        final CountDownLatch finishLatch = new CountDownLatch(1);
        StreamObserver<StockQuote> responseObserver = new StreamObserver<StockQuote>() {
            @Override
            public void onNext(StockQuote stockQuote) {
                log.info("RESPONSE price#{} : {}, description:{}", stockQuote.getOfferNumber(), stockQuote.getPrice(), stockQuote.getDescription());
            }
    
            @Override
            public void onCompleted() {
                log.info("Finished bidirectionalStreamingGetListsStockQuotes");
                finishLatch.countDown();
            }

            @Override
            public void onError(Throwable t) {
                log.error("bidirectionalStreamingGetListsStockQuotes Failed: {}", Status.fromThrowable(t));
                finishLatch.countDown();
            }
        };

        StreamObserver<Stock> requestObserver = nonBlockingStub.bidirectionalStreamingGetListsStockQuotes(responseObserver);
        try {
            for (Stock stock : stocks) {
                log.info("REQUEST: {}, {}", stock.getTickerSymbol(), stock.getCompanyName());
                requestObserver.onNext(stock);
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
            log.warn("bidirectionalStreamingGetListsStockQuotes can not finish within 1 minute");
        }
    }

    private void initializeStocks() {
        this.stocks = Arrays.asList(Stock.newBuilder().setTickerSymbol("AU").setCompanyName("Auburn Corp").setDescription("Aptitude Intel").build()
                , Stock.newBuilder().setTickerSymbol("BAS").setCompanyName("Bassel Corp").setDescription("Business Intel").build()
                , Stock.newBuilder().setTickerSymbol("COR").setCompanyName("Corvine Corp").setDescription("Corporate Intel").build()
                , Stock.newBuilder().setTickerSymbol("DIA").setCompanyName("Dialogic Corp").setDescription("Development Intel").build()
                , Stock.newBuilder().setTickerSymbol("EUS").setCompanyName("Euskaltel Corp").setDescription("English Intel").build());
    }

}
