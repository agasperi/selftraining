package com.example.coffee.redis;

import java.util.UUID;

import javax.annotation.PostConstruct;

import com.example.coffee.model.Coffee;

import org.springframework.data.redis.connection.ReactiveRedisConnectionFactory;
import org.springframework.data.redis.core.ReactiveRedisOperations;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;

@Component
@RequiredArgsConstructor
public class CoffeeLoader {
    private final ReactiveRedisConnectionFactory factory;
    private final ReactiveRedisOperations<String, Coffee> coffeeOps;

    @PostConstruct 
    public void loadData() {
        factory.getReactiveConnection()
            .serverCommands()
            .flushAll()
            .thenMany(
                    Flux.just("Jet Black Redis", "Darth Redis", "Black Alert Redis")
                        .map(name -> new Coffee(UUID.randomUUID().toString(), name))
                        .flatMap(coffee -> coffeeOps.opsForValue().set(coffee.getId(), coffee)))
            .thenMany(coffeeOps.keys("*").flatMap(coffeeOps.opsForValue()::get))
            .subscribe(System.out::println);
    }
    
}
