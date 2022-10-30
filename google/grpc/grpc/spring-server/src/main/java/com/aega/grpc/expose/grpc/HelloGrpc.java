package com.aega.grpc.expose.grpc;

import com.aega.grpc.proto.HelloRequest;
import com.aega.grpc.proto.HelloResponse;
import com.aega.grpc.proto.HelloServiceGrpc.HelloServiceImplBase;
import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.server.service.GrpcService;


@Slf4j
@GrpcService
public class HelloGrpc extends HelloServiceImplBase {

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
