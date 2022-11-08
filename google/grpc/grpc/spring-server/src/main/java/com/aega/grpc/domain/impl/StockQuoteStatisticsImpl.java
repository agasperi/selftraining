package com.aega.grpc.domain.impl;

import org.springframework.stereotype.Component;

import com.aega.grpc.domain.StockQuoteBuilder;
import com.aega.grpc.domain.StockQuoteStatistics;
import com.aega.grpc.proto.Stock;
import com.aega.grpc.proto.StockQuote;


@Component
public class StockQuoteStatisticsImpl implements StockQuoteStatistics {

    private int count;
    private double price;
    private StringBuilder sb;

    public StockQuoteStatisticsImpl() {
        initialize();
    }

    @Override
    public void addStock(Stock stock) {
        this.count++;
        this.price = +StockQuoteBuilder.fetchStockPriceBid(stock);
        this.sb.append(":")
            .append(stock.getTickerSymbol());
    }

    @Override
    public StockQuote getStatistics() {
        double averagePrice = this.count != 0 ? this.price / this.count : 0.0;
        String statistics = this.sb.toString();
        this.initialize();
        return StockQuote.newBuilder()
            .setPrice(averagePrice)
            .setDescription("Statistics-" + statistics)
            .build();
    }

    private void initialize() {
        count = 0;
        price = 0.0;
        sb = new StringBuilder();
    }

}
