package com.aega.quarkus.panache.model;

import java.time.Instant;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "t_purchase_order_lines")
public class OrderLine extends PanacheEntity{

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name="item_fk")
    private Item item;

    @Column(nullable = false)
    private Integer quantity;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "purchase_order_fk")
    private PurchaseOrder purchaseOrder;

    @Column(name = "created_date", nullable = false)
    public Instant createdDate = Instant.now();

}
