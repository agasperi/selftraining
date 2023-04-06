package com.aega.quarkus.panache.model;

import com.aega.quarkus.jpa.Customer;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "t_purchase_orders")
public class PurchaseOrder extends PanacheEntity{

    @Column(name = "purchase_order_date", nullable = false)
    private LocalDate date = LocalDate.now();

    @OneToMany(mappedBy = "purchaseOrder",
            cascade = {CascadeType.REMOVE, CascadeType.PERSIST},
            orphanRemoval = true)
    private List<OrderLine> orderLines = new ArrayList<>();

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "customer_fk")
    private Customer customer;

    @Column(name = "created_date", nullable = false)
    private Instant createdDate = Instant.now();

    public void addOrderLine(OrderLine orderLine) {
        orderLines.add(orderLine);
        orderLine.setPurchaseOrder(this);
    }

    public void removedOrderLine(OrderLine orderLine) {
        orderLines.remove(orderLine);
        orderLine.setPurchaseOrder(null);
    }

}
