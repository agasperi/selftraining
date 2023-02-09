package com.aega.quarkus.starting;

import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor
public class Book {

    private int id;
    private String title;
    private String author;
    private int yearOfPublication;
    private String genre;
 
}
