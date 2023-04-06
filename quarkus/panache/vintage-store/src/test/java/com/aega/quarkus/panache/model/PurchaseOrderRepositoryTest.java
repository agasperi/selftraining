package com.aega.quarkus.panache.model;

import io.quarkus.test.TestTransaction;
import io.quarkus.test.junit.QuarkusTest;

import java.math.BigDecimal;

import javax.inject.Inject;
import javax.persistence.criteria.Order;

import org.junit.jupiter.api.Test;

import com.aega.quarkus.jdbc.Artist;
import com.aega.quarkus.jpa.Customer;
import com.aega.quarkus.panache.repository.CustomerRepository;


@QuarkusTest
class PurchaseOrderRepositoryTest {

    @Inject
    private CustomerRepository customerRepository;

    @Test
    @TestTransaction
    void shouldCreateAndFindAPurchaseOrder() {

        // Creates an Artist
        Artist artist = new Artist("Artist name", "Artist bio");
        // Creates a Publisher
        Publisher publisher = new Publisher("Publisher name");
        // Creates a Book
        Book book = new Book();
        book.setTitle("Title of the book");
        book.setNbOfPages(500);
        book.setLanguage(Language.ENGLISH);
        book.setPrice(new BigDecimal(10));
        book.setIsbn("isbn");

        // Sets the relationships
        book.setPublisher(publisher);
        book.setArtist(artist);
        // Persists the book
        Book.persist(book);

        // Creates a Customer
        Customer customer = new Customer("Customer first name", "Customer last name", "customer@email.com");
        customerRepository.persist(customer);

        // Creates an Order Line
        OrderLine orderLine = new OrderLine();
        orderLine.setItem(book);
        orderLine.setQuantity(2);

        // Creates a Purchase Order
        PurchaseOrder purchaseOrder = new PurchaseOrder();
        purchaseOrder.setCustomer(customer);
        purchaseOrder.addOrderLine(orderLine);

        PurchaseOrder.persist(purchaseOrder);
    }

}
