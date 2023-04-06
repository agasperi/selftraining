package com.aega.quarkus.jpa;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import io.quarkus.test.TestTransaction;
import io.quarkus.test.junit.QuarkusTest;
import javax.inject.Inject;
import org.junit.jupiter.api.Test;


@QuarkusTest
class CustomerRepositoryTest {

    @Inject
    CustomerRepository repository;

    @Test
    @TestTransaction
    void shouldCreateAndFindACustomer() {
        Customer customer = new Customer("firts name","last name", "flast@correo.com");

        repository.persist(customer);
        assertNotNull(customer);

        customer = repository.findById(customer.getId());
        assertEquals("firts name", customer.getFirstName());
    }

}
