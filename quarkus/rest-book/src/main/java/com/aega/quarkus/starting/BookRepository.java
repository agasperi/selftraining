package com.aega.quarkus.starting;

import jakarta.enterprise.context.ApplicationScoped;
import java.util.List;
import java.util.Optional;
import org.eclipse.microprofile.config.inject.ConfigProperty;


@ApplicationScoped
public class BookRepository {

    @ConfigProperty(name="books.genre", defaultValue = "Sci-Fi")
    String genre;

    public List<Book> getAllBooks() {
        return List.of(
            new Book(1, "Book 1", "Pepe", 2018, genre),
            new Book(2, "Book 2", "Sancho", 2019, genre),
            new Book(3, "Book 3", "Lucho", 2020, genre),
            new Book(4, "Book 4", "Maria", 2021, genre)
        );
    }

    public int countAllBooks() {
        return getAllBooks().size();
    }

    public Optional<Book> getBook(int id) {
        return getAllBooks().stream()
                .filter(book -> book.getId() == id)
                .findFirst();
    }

}