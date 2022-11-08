package com.aega.grpc.domain;

import java.util.concurrent.ThreadLocalRandom;

import com.aega.grpc.proto.Stock;
import com.aega.grpc.proto.StockQuote;

public interface StockQuoteBuilder {

    public StockQuote createFromStock(Stock stock, int offerNumber);

    public static double fetchStockPriceBid(Stock stock)  {
        return stock.getTickerSymbol().length()
                + ThreadLocalRandom.current().nextDouble(-0.1d, 0.1d);
    }

}
