package com.aega.quarkus.jdbc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import io.quarkus.test.junit.QuarkusTest;
import java.sql.SQLException;
import javax.inject.Inject;
import org.junit.jupiter.api.Test;


@QuarkusTest
class ArtistRepositoryTest {

    @Inject
    ArtistRepository repository;

    @Test
    void shouldCreateAndFindAnArtist() throws SQLException {
        Artist artist = new Artist("name", "bio");

        repository.persist(artist);
        assertNotNull(artist.getId());

        repository.finArtist(artist.getId());
        assertEquals("name", artist.getName());
    }

}
