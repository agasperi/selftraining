package com.aega.grpc.service.impl;

import io.grpc.stub.StreamObserver;
import java.util.concurrent.ThreadLocalRandom;
import lombok.extern.slf4j.Slf4j;
import org.baeldung.grpc.Stock;
import org.baeldung.grpc.StockQuote;
import org.baeldung.grpc.StockQuoteProviderGrpc.StockQuoteProviderImplBase;


@Slf4j
public class StockServiceImpl extends StockQuoteProviderImplBase {

    @Override
    public void serverSideStreamingGetListStockQuotes(Stock request, StreamObserver<StockQuote> responseObserver) {
        for (int i = 1; i <= 5; i++) {
            StockQuote stockQuote = StockQuote.newBuilder()
                    .setPrice(fetchStockPriceBid(request))
                    .setOfferNumber(i)
                    .setDescription("Price for stock:" + request.getTickerSymbol())
                    .build();
            responseObserver.onNext(stockQuote);
        }
        responseObserver.onCompleted();
    }

    @Override
    public StreamObserver<Stock> clientSideStreamingGetStatisticsOfStocks(StreamObserver<StockQuote> responseObserver) {
        return new StreamObserver<Stock>() {
            int count;
            double price = 0.0;
            StringBuilder sb = new StringBuilder();

            @Override
            public void onNext(Stock stock) {
                count++;
                price = +fetchStockPriceBid(stock);
                sb.append(":")
                    .append(stock.getTickerSymbol());
            }

            @Override
            public void onCompleted() {
                responseObserver.onNext(StockQuote.newBuilder()
                    .setPrice(price / count)
                    .setDescription("Statistics-" + sb.toString())
                    .build());
                responseObserver.onCompleted();
            }

            @Override
            public void onError(Throwable t) {
                log.error("error:{}", t.getMessage());
            }
        };
    }

    @Override
    public StreamObserver<Stock> bidirectionalStreamingGetListsStockQuotes(StreamObserver<StockQuote> responseObserver) {
        return new StreamObserver<Stock>() {
            @Override
            public void onNext(Stock request) {
                for (int i = 1; i <= 5; i++) {
                    StockQuote stockQuote = StockQuote.newBuilder()
                    .setPrice(fetchStockPriceBid(request))
                    .setOfferNumber(i)
                    .setDescription("Price for stock:" + request.getTickerSymbol())
                    .build();
                    responseObserver.onNext(stockQuote);
                }
            }

            @Override
            public void onCompleted() {
                responseObserver.onCompleted();
            }

            @Override
            public void onError(Throwable t) {
                log.error("error:{}", t.getMessage());
            }
        };
    }

    private static double fetchStockPriceBid(Stock stock) {
        return stock.getTickerSymbol().length()
                + ThreadLocalRandom.current().nextDouble(-0.1d, 0.1d);
    }

}
