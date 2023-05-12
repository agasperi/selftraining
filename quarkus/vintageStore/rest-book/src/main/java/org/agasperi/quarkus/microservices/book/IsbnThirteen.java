package org.agasperi.quarkus.microservices.book;

import lombok.Getter;
import lombok.Setter;

import javax.json.bind.annotation.JsonbProperty;

@Getter
@Setter
public class IsbnThirteen {

    @JsonbProperty("isbn_13")
    private String isbn13;

}
