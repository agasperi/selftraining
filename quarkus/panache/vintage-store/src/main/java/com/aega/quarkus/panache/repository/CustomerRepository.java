package com.aega.quarkus.panache.repository;

import com.aega.quarkus.jpa.Customer;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.panache.common.Sort;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;


@ApplicationScoped
public class CustomerRepository implements PanacheRepository<Customer> {

    public List<Customer> listAllDans() {
        return list("first_name = 'Dan'", Sort.by("lastName"));
    }

}
