package com.aega.quarkus.panache.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


/**
 * Example JPA entity defined as a Panache Entity.
 * An ID field of Long type is provided, if you want to define your own ID field extends <code>PanacheEntityBase</code> instead.
 *
 * This uses the active record pattern, you can also use the repository pattern instead:
 * .
 *
 * Usage (more example on the documentation)
 *
 * {@code
 *     public void doSomething() {
 *         MyEntity entity1 = new MyEntity();
 *         entity1.field = "field-1";
 *         entity1.persist();
 *
 *         List<MyEntity> entities = MyEntity.listAll();
 *     }
 * }
 */
@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "t_publishers")
public class Publisher extends PanacheEntity {

    @Column(length = 50, nullable = false)
    private String name;
    @Column(name = "created_date", nullable = false)
    private Instant createdDate = Instant.now();

    public Publisher(String name) {
        this.name = name;
    }

    public static Optional<Publisher> findByName(String name) {
        return Publisher.find("name", name).firstResultOptional();
    }

    public static List<Publisher> findContainName(String name) {
        return Publisher.list("name like ?1", "%" + name + "%");
    }

}
 