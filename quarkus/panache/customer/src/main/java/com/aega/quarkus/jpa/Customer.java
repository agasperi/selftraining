package com.aega.quarkus.jpa;

import java.time.Instant;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "t_customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
  
    @Column(name = "first_name", length = 50, nullable = false)
    private String firstName;
  
    @Column(name = "last_name", length = 50, nullable = false)
    private String lastName;
  
    @Column(name = "e_mail", nullable = false)
    private String email;

    @Column(name = "created_date", nullable = false)
    private Instant createdDate = Instant.now();

    public Customer(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

}