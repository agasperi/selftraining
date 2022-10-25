package com.aega.grpc;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import java.io.IOException;
import lombok.extern.slf4j.Slf4j;
import org.baeldung.grpc.HelloRequest;
import org.baeldung.grpc.HelloResponse;
import org.baeldung.grpc.HelloServiceGrpc;


@Slf4j
public class App {

    public static void main( String[] args ) throws IOException, InterruptedException {
        log.info("Iniciando cliente gRPC!");
        ManagedChannel channel = ManagedChannelBuilder
                .forAddress("localhost", 8080)
                .usePlaintext()
                .build();

        HelloServiceGrpc.HelloServiceBlockingStub stub =
                HelloServiceGrpc.newBlockingStub(channel);

        HelloResponse helloResponse = stub.hello(HelloRequest.newBuilder()
                .setFirstName("Arnoldo")
                .setLastName("Gasperi")
                .build());
        
        log.info(new StringBuilder()
            .append("Response received from server:\n")
            .append(helloResponse)
            .toString());

        channel.shutdown();
    }

}
