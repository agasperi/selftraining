package org.acme.getting.started.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.UUID;
import org.acme.getting.started.GreetingService;
import org.junit.jupiter.api.Test;


class GreetingServiceImplTest {

    @Test
    void testGreetingEndpoint() {
        GreetingService service = new GreetingServiceImpl();
        String uuid = UUID.randomUUID().toString();
        String expected = GreetingServiceImpl.MSG_HELLO + uuid;
        String actual = service.greeting(uuid);
        assertEquals(expected,actual);
    }

}
