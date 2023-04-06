package com.aega.quarkus.panache.model;

import java.time.LocalDate;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
public class Book extends Item{

    @Column(length = 15)
    private String isbn;
    @Column(name = "nb_of_pages")
    private int nbOfPages;
    @Column(name = "publication_date")
    private LocalDate publicationDate;
    @Column(length = 20)
    @Enumerated(EnumType.STRING)
    private Language language;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "publisher_fk")
    private Publisher publisher;

    /*@Override
    public String toString() {
      return "Book{" +
        "isbn='" + isbn + '\'' +
        ", nbOfPages=" + nbOfPages +
        ", publicationDate=" + publicationDate +
        ", language=" + language +
        ", publisher=" + publisher +
        ", title='" + super.getTitle() + '\'' +
        ", description='" + super.getDescription() + '\'' +
        ", price=" + super.getPrice() +
        ", createdDate=" + super.getCreatedDate() +
        ", id=" + id +
        '}';
    }*/

}
