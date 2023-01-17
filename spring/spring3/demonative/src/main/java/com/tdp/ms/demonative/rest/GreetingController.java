package com.tdp.ms.demonative.rest;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tdp.ms.demonative.service.GreetingService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/hello")
@RequiredArgsConstructor
public class GreetingController {

    public static final String MSG_HELLO = "Hello from Spring Boot 3 Reactive";

    private final GreetingService service;

    @GetMapping(value = "/greeting/{name}",
                produces = MediaType.TEXT_PLAIN_VALUE)
    public String greeting (String name) {
        return service.greeting(name);
    }

    @GetMapping(produces = MediaType.TEXT_PLAIN_VALUE)
    public String hello() {
        return MSG_HELLO;
    }

}
