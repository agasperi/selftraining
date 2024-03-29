package org.agasperi.quarkus.microservices.number;


import org.agasperi.quarkus.microservices.number.dto.IsbnNumbers;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.time.Instant;
import java.util.Random;

@Path("/api/numbers")
@Tag(name="Number REST Endpoint")
public class NumberResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(
          summary = "Generates book numbers",
          description = "ISBN 13 and ISBN 10 numbers"
    )
    public IsbnNumbers generateIsbnNumbers(){
        IsbnNumbers isbnNumbers = new IsbnNumbers();
        isbnNumbers.setIsbn13("13-" +  new Random().nextInt(100_000_000));
        isbnNumbers.setIsbn10("10-" +  new Random().nextInt(100_000));
        isbnNumbers.setGenerationDate(Instant.now());
        return isbnNumbers;
    }

}