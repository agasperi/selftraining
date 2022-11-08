package com.aega.grpc.domain.impl;

import com.aega.grpc.domain.StockQuoteBuilder;
import com.aega.grpc.proto.Stock;
import com.aega.grpc.proto.StockQuote;

public class StockQuoteBuilderImpl implements StockQuoteBuilder{

    @Override
    public StockQuote createFromStock(Stock stock, int offerNumber) {
        // TODO Auto-generated method stub
        return StockQuote.newBuilder()
            .setPrice(StockQuoteBuilder.fetchStockPriceBid(stock))
            .setOfferNumber(offerNumber)
            .setDescription("Price for stock:" + stock.getTickerSymbol())
            .build();
    }
    
}
