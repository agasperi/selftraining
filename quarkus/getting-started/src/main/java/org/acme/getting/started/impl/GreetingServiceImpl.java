package org.acme.getting.started.impl;

import javax.enterprise.context.ApplicationScoped;

import org.acme.getting.started.GreetingService;

@ApplicationScoped
public class GreetingServiceImpl implements GreetingService {

    public static final String MSG_HELLO = "hello ";

    public String greeting (String name) {
        return MSG_HELLO + name;
    }

}
