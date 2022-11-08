package com.aega.grpc.expose.rest;

import com.aega.grpc.expose.rest.dto.StockQuoteResponse;
import com.aega.grpc.expose.rest.dto.StockRequest;
import com.aega.grpc.proto.Stock;
import com.aega.grpc.service.StockQuoteService;
import com.aega.grpc.util.IteratorMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;


@RestController
@RequestMapping("/stockquote")
@RequiredArgsConstructor
public class StockQuoteController {

    private final StockQuoteService service;

    @PostMapping("/listofstock")
    public Flux<StockQuoteResponse> listOfStock(@RequestBody StockRequest stock) {
        return Flux.fromStream(
                IteratorMapper.getStream(
                    service.getListStockQuotes(
                        Stock.newBuilder()
                                .setTickerSymbol(stock.getTickerSymbol())
                                .setCompanyName(stock.getCompanyName())
                                .setDescription(stock.getDescription())
                            .build())))
            .map(sq -> new StockQuoteResponse(
                    sq.getPrice(), sq.getOfferNumber(), sq.getDescription()));
    }

}
