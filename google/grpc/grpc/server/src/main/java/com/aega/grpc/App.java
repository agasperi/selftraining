package com.aega.grpc;

import com.aega.grpc.service.GrpcServer;
import java.io.IOException;
import lombok.extern.slf4j.Slf4j;


@Slf4j
public class App {

    public static void main( String[] args ) throws IOException, InterruptedException {
        GrpcServer grpcServer = new GrpcServer(8080);
        grpcServer.start();
    }

}
