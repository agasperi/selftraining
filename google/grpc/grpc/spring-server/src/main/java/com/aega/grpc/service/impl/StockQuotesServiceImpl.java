package com.aega.grpc.service.impl;

import com.aega.grpc.domain.StockQuoteBuilder;
import com.aega.grpc.domain.StockQuoteStatistics;
import com.aega.grpc.proto.Stock;
import com.aega.grpc.proto.StockQuote;
import com.aega.grpc.service.StockQuotesService;

import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.stream.Stream;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class StockQuotesServiceImpl implements StockQuotesService {

    private final StockQuoteStatistics stockQuoteStatistics;

    @Override
    public Stream<StockQuote> getListStockQuotes(Stock request) {
        return List.of(1, 2, 3, 4, 5)
            .stream()
            .map(i -> StockQuote.newBuilder()
                .setPrice(StockQuoteBuilder.fetchStockPriceBid(request))
                .setOfferNumber(i)
                .setDescription("Price for stock:" + request.getTickerSymbol())
                .build()
            );
    }

    @Override
    public void addStatisticsOfStock(Stock stock) {
        stockQuoteStatistics.addStock(stock);
    }

    @Override
    public StockQuote getStatitics() {
        return stockQuoteStatistics.getStatistics();
    }

}
