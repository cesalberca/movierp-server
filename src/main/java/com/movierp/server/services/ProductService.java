package com.movierp.server.services;

import com.movierp.server.entities.Movie;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository
@RepositoryRestResource(collectionResourceRel = "clients", path = "clients")
public interface ProductService extends CrudRepository<Movie, Long> {
}
