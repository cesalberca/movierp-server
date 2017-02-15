package com.movierp.server.services;

import com.movierp.server.entities.Cinema;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "cinemas", path = "cinemas")
public interface CinemaService extends CrudRepository<Cinema, Long> {
    @RestResource(path = "findByNombre")
    List<Cinema> findByNombre(@Param("nombre") String name);
}
