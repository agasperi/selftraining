package com.aega.quarkus.panache.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import io.quarkus.test.TestTransaction;
import io.quarkus.test.junit.QuarkusTest;
import javax.inject.Inject;
import org.junit.jupiter.api.Test;

import com.aega.quarkus.jdbc.Artist;


@QuarkusTest
class ArtistRepositoryTest {

    @Inject
    ArtistRepository repository;

    @Test
    @TestTransaction
    void shouldCreateAndFindAnArtist() {
        long count = repository.count();
        int listAll = repository.listAll().size();
        assertEquals(count, listAll);

        assertEquals(repository.listAllArtistsSorted().size(), listAll);

        Artist artist = new Artist("name", "bio");
        repository.persist(artist);
        assertNotNull(artist.getId());
        assertEquals(count + 1, repository.count());

        repository.findById(artist.getId());
        assertEquals("name", artist.getName());

        repository.deleteById(artist.getId());
        assertEquals(count, repository.count());
    }

}
