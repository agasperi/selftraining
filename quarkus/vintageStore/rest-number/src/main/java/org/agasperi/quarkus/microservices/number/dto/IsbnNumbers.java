package org.agasperi.quarkus.microservices.number.dto;

import java.time.Instant;
import lombok.Getter;
import lombok.Setter;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

import javax.json.bind.annotation.JsonbProperty;
import javax.json.bind.annotation.JsonbTransient;


@Getter
@Setter
@Schema(description = "Several ISBN numbers for books")
public class IsbnNumbers {
    @Schema(required = true)
    @JsonbProperty("isbn_10")
    private String isbn10;
    @Schema(required = true)
    @JsonbProperty("isbn_13")
    private String isbn13;
    @JsonbTransient
    private Instant generationDate;
}
