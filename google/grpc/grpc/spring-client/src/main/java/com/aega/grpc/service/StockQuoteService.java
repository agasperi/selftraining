package com.aega.grpc.service;

import java.util.Iterator;

import com.aega.grpc.proto.Stock;
import com.aega.grpc.proto.StockQuote;

public interface StockQuoteService {

    public Iterator<StockQuote> getListStockQuotes(Stock stock);

}
