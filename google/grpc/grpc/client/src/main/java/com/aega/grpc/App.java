package com.aega.grpc;

import java.util.concurrent.TimeUnit;

import com.aega.grpc.client.HelloClient;
import com.aega.grpc.client.StockClient;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import lombok.extern.slf4j.Slf4j;


@Slf4j
public class App {

    public static void main( String[] args ) throws InterruptedException {
        log.info("Iniciando cliente gRPC!");
        ManagedChannel channel = ManagedChannelBuilder
                .forAddress("localhost", 8080)
                .usePlaintext()
                .build();

        try {
            HelloClient helloClient = new HelloClient(channel);
            helloClient.hello();
    
            StockClient stockClient = new StockClient(channel);
            stockClient.serverSideStreamingListOfStockPrices();
            stockClient.clientSideStreamingGetStatisticsOfStocks();
            stockClient.bidirectionalStreamingGetListsStockQuotes();
        } finally {
            channel.shutdownNow()
                .awaitTermination(5, TimeUnit.SECONDS);
        }
    }

}
