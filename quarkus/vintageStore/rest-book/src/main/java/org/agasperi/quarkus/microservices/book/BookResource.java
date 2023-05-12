package org.agasperi.quarkus.microservices.book;

import javax.inject.Inject;
import javax.json.bind.JsonbBuilder;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.Path;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.Instant;

import org.eclipse.microprofile.faulttolerance.Fallback;
import org.eclipse.microprofile.faulttolerance.Retry;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.jboss.logging.Logger;

@Path("/api/books")
@Tag(name = "Book REST endpoint")
public class BookResource {
    @Inject
    Logger logger;
    @RestClient
    NumberProxy numberProxy;

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Operation(
            summary = "Creates a book",
            description = "Creates a book with an ISBN number"
    )
    @Fallback(fallbackMethod = "fallingbackOnCreatingABook")
    @Retry(maxRetries = 3, delay = 3000)
    public Response createABook(@FormParam("title") String title,
                                @FormParam("author") String author,
                                @FormParam("year") int yearOfPublication,
                                @FormParam("genre") String genre) {
        Book book = new Book();
        book.setIsbn13(numberProxy.generateIsbnNumbers().getIsbn13());
        book.setCreationDate(Instant.now());
        book.setAuthor(author);
        book.setGenre(genre);
        book.setTitle(title);
        book.setYearOfPublication(yearOfPublication);
        logger.info("Book created: " + book);
        return Response.status(201)
                .entity(book)
                .build();
    }

    private Response fallingbackOnCreatingABook(String title,
                                String author,
                                int yearOfPublication,
                                String genre) throws FileNotFoundException {
        Book book = new Book();
        book.setIsbn13("Will be set later");
        book.setCreationDate(Instant.now());
        book.setAuthor(author);
        book.setGenre(genre);
        book.setTitle(title);
        book.setYearOfPublication(yearOfPublication);
        saveBookOnDisk(book);
        logger.warn("Book saved on disk: " + book);
        return Response.status(206)
                .entity(book)
                .build();
    }

    private void saveBookOnDisk(Book book) throws FileNotFoundException {
        String bookJson = JsonbBuilder.create().toJson(book);
        try (PrintWriter out = new PrintWriter("book-" + Instant.now().toEpochMilli() + ".json")){
            out.println(bookJson);
        }
    }

}
