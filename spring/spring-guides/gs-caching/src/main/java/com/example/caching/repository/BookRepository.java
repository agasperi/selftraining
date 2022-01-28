package com.example.caching.repository;

import com.example.caching.model.Book;

public interface BookRepository {

    Book getByIsbn(String isbn);

}
