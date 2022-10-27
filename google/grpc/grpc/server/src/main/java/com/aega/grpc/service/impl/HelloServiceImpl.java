package com.aega.grpc.service.impl;

import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;
import org.baeldung.grpc.HelloRequest;
import org.baeldung.grpc.HelloResponse;
import org.baeldung.grpc.HelloServiceGrpc.HelloServiceImplBase;


@Slf4j
public class HelloServiceImpl extends HelloServiceImplBase {

    @Override
    public void hello(HelloRequest request, StreamObserver<HelloResponse> responseObserver) {
        log.info("Procesando peticion gRPC!");  
        String greeting = new StringBuilder()
            .append("Hello, ")
            .append(request.getFirstName())
            .append(" ")
            .append(request.getLastName())
            .toString();

        HelloResponse response = HelloResponse.newBuilder()
            .setGreeting(greeting)
            .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

}
