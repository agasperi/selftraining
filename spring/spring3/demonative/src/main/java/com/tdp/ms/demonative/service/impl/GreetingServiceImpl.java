package com.tdp.ms.demonative.service.impl;

import org.springframework.stereotype.Service;

import com.tdp.ms.demonative.service.GreetingService;

@Service
public class GreetingServiceImpl implements GreetingService {

    public static final String MSG_HELLO = "hello ";

    @Override
    public String greeting(String name) {
        return MSG_HELLO + name;
    }
    
}
