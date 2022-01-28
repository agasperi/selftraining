package com.example.coffee.controller;

import com.example.coffee.model.Coffee;

import org.springframework.data.redis.core.ReactiveRedisOperations;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/coffees")
@RequiredArgsConstructor
public class CoffeeController {
    private final ReactiveRedisOperations<String, Coffee> coffeeOps;

    @GetMapping
    public Flux<Coffee> all() {
        return coffeeOps.keys("*")
            .flatMap(coffeeOps.opsForValue()::get);
    }
}
