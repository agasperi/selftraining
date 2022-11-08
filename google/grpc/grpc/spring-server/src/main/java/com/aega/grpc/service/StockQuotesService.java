package com.aega.grpc.service;

import com.aega.grpc.proto.Stock;
import com.aega.grpc.proto.StockQuote;
import java.util.stream.Stream;


public interface StockQuotesService {

    public Stream<StockQuote> getListStockQuotes(Stock request);
    public void addStatisticsOfStock(Stock stock);
    public StockQuote getStatitics();

}
