package com.aega.grpc.expose.rest.dto;

import lombok.Value;


@Value
public class StockQuoteResponse {
    double price;
    int offerNumber;
    String description;
}
