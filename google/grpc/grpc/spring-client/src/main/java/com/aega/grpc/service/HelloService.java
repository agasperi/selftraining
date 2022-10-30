package com.aega.grpc.service;

import com.aega.grpc.expose.rest.dto.HelloRequest;
import com.aega.grpc.expose.rest.dto.HelloResponse;

public interface HelloService {

    public HelloResponse hello(HelloRequest request) ;

}
