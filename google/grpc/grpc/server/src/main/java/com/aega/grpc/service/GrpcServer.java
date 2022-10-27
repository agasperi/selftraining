package com.aega.grpc.service;

import com.aega.grpc.service.impl.CommodityPriceServiceImpl;
import com.aega.grpc.service.impl.HelloServiceImpl;
import com.aega.grpc.service.impl.StockServiceImpl;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import java.io.IOException;
import lombok.extern.slf4j.Slf4j;


@Slf4j
public class GrpcServer {

    private final int port;
    private final Server server;

    public GrpcServer(int port) {
        this.port = port;
        server = ServerBuilder
                .forPort(port)
                .addService(new HelloServiceImpl())
                .addService(new StockServiceImpl())
                .addService(new CommodityPriceServiceImpl())
                .build();
    }

    public void start() throws IOException, InterruptedException {
        server.start();
        log.info("Server started, listening on " + port);
        server.awaitTermination();
    }

}
