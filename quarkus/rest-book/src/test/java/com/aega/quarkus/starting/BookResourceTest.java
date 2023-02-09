package com.aega.quarkus.starting;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

import jakarta.ws.rs.core.HttpHeaders;
import jakarta.ws.rs.core.MediaType;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;


@QuarkusTest
class BookResourceTest {

    @Test
    void shouldGetAllBooks() {
        given()
            .header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON)
        .when()
            .get("/api/books")
        .then()
            .statusCode(200)
            .body("size()",is(4));
    }

    @Test
    void shouldCountAllBooks() {
        given()
            .header(HttpHeaders.ACCEPT, MediaType.TEXT_PLAIN)
        .when()
            .get("/api/books/count")
        .then()
            .statusCode(200)
            .body(is("4"));
    }

    @Test
    void shouldGetABooks() {
        given()
            .header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON)
            .pathParam("id", 1)
        .when()
            .get("/api/books/{id}")
        .then()
            .statusCode(200)
            .body("title",is("Book 1"))
            .body("author",is("Pepe"))
            .body("yearOfPublication",is(2018))
            .body("genre",is("IT"));
    }

}