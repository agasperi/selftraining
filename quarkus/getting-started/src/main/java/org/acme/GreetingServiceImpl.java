package org.acme;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class GreetingServiceImpl implements GreetingService {

    public String greeting (String name) {
        return "hello " + name;
    }
    
}
