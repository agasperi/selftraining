package com.aega.quarkus.starting;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

import io.quarkus.test.junit.QuarkusIntegrationTest;
import jakarta.ws.rs.core.HttpHeaders;
import jakarta.ws.rs.core.MediaType;

import org.junit.jupiter.api.Test;


@QuarkusIntegrationTest
public class BookResourceIT extends BookResourceTest {
    // Execute the same tests but in packaged mode.

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
            .body("genre",is("Information Technology"));
    }

}
