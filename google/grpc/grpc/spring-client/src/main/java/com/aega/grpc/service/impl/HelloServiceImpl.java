package com.aega.grpc.service.impl;

import org.springframework.stereotype.Service;

import com.aega.grpc.proto.HelloRequest;
import com.aega.grpc.proto.HelloResponse;
import com.aega.grpc.proto.HelloServiceGrpc.HelloServiceBlockingStub;
import com.aega.grpc.service.HelloService;

import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.client.inject.GrpcClient;


@Slf4j
@Service
public class HelloServiceImpl implements HelloService {

    @GrpcClient("hello_service")
    private HelloServiceBlockingStub helloStub;

    @Override
    public com.aega.grpc.expose.rest.dto.HelloResponse hello(
            com.aega.grpc.expose.rest.dto.HelloRequest request) {
        log.info("***** Hello Example *****: hello");
        HelloResponse helloResponse = helloStub.hello(HelloRequest.newBuilder()
            .setFirstName(request.getFirstName())
            .setLastName(request.getLastName())
            .build());
        return new com.aega.grpc.expose.rest.dto.HelloResponse(helloResponse.getGreeting());
    }
    
}
