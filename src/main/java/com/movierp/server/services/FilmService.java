package com.movierp.server.services;


import com.movierp.server.entities.Movie;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "films", path = "films")
public interface FilmService extends CrudRepository<Movie, Long> {
}
