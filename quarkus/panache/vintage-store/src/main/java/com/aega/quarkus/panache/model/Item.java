package com.aega.quarkus.panache.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import java.math.BigDecimal;
import java.time.Instant;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.aega.quarkus.jdbc.Artist;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name = "t_items")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Item extends PanacheEntity {

    @Column(length = 100, nullable = false)
    private String title;
    @Column(length = 3000)
    private String description;
    @Column(nullable = false)
    private BigDecimal price;
    @Column(name = "created_date", nullable = false)
    private Instant createdDate = Instant.now();

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "artist_fk")
    private Artist artist;

}
