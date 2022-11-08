package com.aega.grpc.domain;

import com.aega.grpc.proto.Stock;
import com.aega.grpc.proto.StockQuote;

public interface StockQuoteStatistics {

    public void addStock(Stock stock);
    public StockQuote getStatistics();

}
