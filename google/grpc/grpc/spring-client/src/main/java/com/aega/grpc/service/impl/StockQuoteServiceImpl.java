package com.aega.grpc.service.impl;

import java.util.Iterator;

import org.springframework.stereotype.Service;

import com.aega.grpc.proto.Stock;
import com.aega.grpc.proto.StockQuote;
import com.aega.grpc.proto.StockQuoteProviderGrpc.StockQuoteProviderBlockingStub;
import com.aega.grpc.service.StockQuoteService;

import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.client.inject.GrpcClient;


@Slf4j
@Service
public class StockQuoteServiceImpl implements StockQuoteService {

    @GrpcClient("stock_quote")
    private StockQuoteProviderBlockingStub blockingStub;

    @Override
    public Iterator<StockQuote> getListStockQuotes(Stock stock) {
        log.info("REQUEST - ticker symbol: {}", stock.getTickerSymbol());
        return blockingStub.serverSideStreamingGetListStockQuotes(stock);
    }

}
