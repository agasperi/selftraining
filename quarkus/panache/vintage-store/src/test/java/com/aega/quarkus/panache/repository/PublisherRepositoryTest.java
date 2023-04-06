package com.aega.quarkus.panache.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.sql.SQLException;

import javax.persistence.EntityNotFoundException;

import org.junit.jupiter.api.Test;

import com.aega.quarkus.panache.model.Publisher;

import io.quarkus.test.TestTransaction;
import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
class PublisherRepositoryTest {

    @Test
    @TestTransaction
    void shouldCreateAndFindAPublisher() throws SQLException {
        long count = Publisher.count();
        int listAll = Publisher.listAll().size();
        assertEquals(count, listAll);

        Publisher publisher = new Publisher("name");
        Publisher.persist(publisher);
        assertNotNull(publisher.id);

        publisher = Publisher.findById(publisher.id);
        assertEquals("name", publisher.getName());

        publisher= Publisher.findByName(publisher.getName())
                .orElseThrow(EntityNotFoundException::new);
        assertEquals("name", publisher.getName());

        assertTrue(Publisher.findContainName("name").size() >= 1);

        Publisher.deleteById(publisher.id);
        assertEquals(count, Publisher.count());
    }
    
}
