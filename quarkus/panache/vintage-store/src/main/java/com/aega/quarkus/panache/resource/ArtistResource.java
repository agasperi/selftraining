package com.aega.quarkus.panache.resource;

import java.util.List;

import com.aega.quarkus.jdbc.Artist;
import com.aega.quarkus.panache.repository.ArtistRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;


@Path("/api/artists")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@ApplicationScoped
@Transactional(Transactional.TxType.SUPPORTS)
public class ArtistResource {

    @Inject
    ArtistRepository repository;

    @GET
    @Path("{id}")
    public Artist findArtistById(@PathParam("id") Long id) {
        return repository.findByIdOptional(id)
                .orElseThrow(NotFoundException::new);
    }

    @GET
    public List<Artist> listAllArtists() {
        return repository.listAll();
    }

    @Transactional(Transactional.TxType.REQUIRED)
    @POST
    public Response persistArtist(Artist artist, @Context UriInfo uriInfo) {
        repository.persist(artist);
        UriBuilder builder = uriInfo.getAbsolutePathBuilder().path(Long.toString(artist.getId()));
        return Response.created(builder.build()).build();
    }

    @Transactional
    @DELETE
    @Path("{id}") 
    public void deleteArtist(@PathParam("id") Long id) {
        repository.deleteById(id);
    }

}
