package com.aega.quarkus.panache.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.aega.quarkus.jpa.Customer;
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
        assertTrue(repository.listAllDans().size() <= repository.count());

        Customer customer = new Customer("firts name","last name", "flast@correo.com");

        repository.persist(customer);
        assertNotNull(customer);

        customer = repository.findById(customer.getId());
        assertEquals("firts name", customer.getFirstName());
    }

}
