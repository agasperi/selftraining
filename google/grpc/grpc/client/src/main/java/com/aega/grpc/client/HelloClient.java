package com.aega.grpc.client;

import io.grpc.ManagedChannel;
import lombok.extern.slf4j.Slf4j;
import org.baeldung.grpc.HelloRequest;
import org.baeldung.grpc.HelloResponse;
import org.baeldung.grpc.HelloServiceGrpc;
import org.baeldung.grpc.HelloServiceGrpc.HelloServiceBlockingStub;


@Slf4j
public class HelloClient {

    private final HelloServiceBlockingStub stub;

    public HelloClient(ManagedChannel channel) {
       stub = HelloServiceGrpc.newBlockingStub(channel);
    }

    public void hello() {
        log.info("***** Hello Example *****: hello");
        HelloResponse helloResponse = stub.hello(HelloRequest.newBuilder()
            .setFirstName("Arnoldo")
            .setLastName("Gasperi")
            .build());
        
        log.info(new StringBuilder()
            .append("Response received from server:\n")
            .append(helloResponse)
            .toString());
    }

}
