package com.tdp.ms.angular.expose;

import java.util.HashMap;
import java.util.Map;

import com.tdp.genesis.core.constants.HttpHeadersKey;
import com.tdp.ms.angular.model.AngularRequest;
import com.tdp.ms.angular.model.AngularResponse;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

@SpringBootTest
@AutoConfigureWebTestClient(timeout = "20000")
public class AngularControllerTest {

    private static final String POST = "post";
    private static final String GENESIS = "genesis";
    private static final String UUID = "550e8400-e29b-41d4-a716-446655440000";

    @Autowired
    private WebTestClient webClient;

    private static Map<String, AngularResponse> angularResponseMap = new HashMap<>();
    private static Map<String, AngularRequest> angularRequestMap = new HashMap<>();

    @BeforeAll
    public static void setUp() {
        angularResponseMap.put("get", new AngularResponse("Hello world!"));
        angularResponseMap.put(POST, new AngularResponse("User created!"));
        angularRequestMap.put(POST, new AngularRequest("User"));
        angularRequestMap.put("empty", new AngularRequest(""));
    }

    @Test
    public void indexGetTest() {
        this.webClient.get()
            .uri("/angular/v1/greeting")
            .accept(MediaType.APPLICATION_JSON)
            .header(HttpHeadersKey.UNICA_SERVICE_ID,UUID)
            .header(HttpHeadersKey.UNICA_APPLICATION,GENESIS)
            .header(HttpHeadersKey.UNICA_PID,UUID)
            .header(HttpHeadersKey.UNICA_USER,GENESIS)
            .header("ClientId","12122322")
            .exchange()
            .expectStatus().isOk()
            .expectBody(AngularResponse.class)
            .isEqualTo(angularResponseMap.get("get"));
    }

    @Test
    public void indexPostTest() {
        this.webClient.post()
            .uri("/angular/v1/greeting")
            .accept(MediaType.APPLICATION_JSON)
            .header(HttpHeadersKey.UNICA_SERVICE_ID,UUID)
            .header(HttpHeadersKey.UNICA_APPLICATION,GENESIS)
            .header(HttpHeadersKey.UNICA_PID,UUID)
            .header(HttpHeadersKey.UNICA_USER,GENESIS)
            .body(BodyInserters.fromValue(angularRequestMap.get(POST)))
            .exchange()
            .expectStatus().isEqualTo(HttpStatus.CREATED)
            .expectBody(AngularResponse.class)
            .isEqualTo(angularResponseMap.get(POST));
    }

}
