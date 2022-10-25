package com.aega.grpc;

import com.aega.grpc.service.HelloServiceImpl;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import java.io.IOException;
import lombok.extern.slf4j.Slf4j;


@Slf4j
public class App {

    public static void main( String[] args ) throws IOException, InterruptedException {
        log.info("Iniciando servidor gRPC!");
        Server server = ServerBuilder
            .forPort(8080)
            .addService(new HelloServiceImpl())
            .build();
        
        server.start();
        server.awaitTermination();
    }

}
