package com.aega.grpc.expose.rest;

import com.aega.grpc.expose.rest.dto.HelloRequest;
import com.aega.grpc.expose.rest.dto.HelloResponse;
import com.aega.grpc.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/hello")
public class HelloController {

    @Autowired
    HelloService service;

    @PostMapping
    public HelloResponse get(@RequestBody HelloRequest request) {
        return service.hello(request);
    }

}
