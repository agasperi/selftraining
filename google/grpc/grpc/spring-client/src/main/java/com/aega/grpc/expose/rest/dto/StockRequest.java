package com.aega.grpc.expose.rest.dto;

import lombok.Value;


@Value
public class StockRequest {

    String tickerSymbol;
    String companyName;
    String description;

}
