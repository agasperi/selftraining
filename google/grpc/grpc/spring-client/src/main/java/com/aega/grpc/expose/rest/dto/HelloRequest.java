package com.aega.grpc.expose.rest.dto;

import lombok.Value;


@Value
public class HelloRequest {
    private String firstName;
    private String lastName;
}
