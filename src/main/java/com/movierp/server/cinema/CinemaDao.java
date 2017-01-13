package com.movierp.server.cinema;

import javax.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.stereotype.Repository;

import java.util.List;
import org.springframework.data.repository.query.Param;

@Transactional
@RepositoryRestResource(path = "cinemas", collectionResourceRel = "cinemas")
public interface CinemaDao extends CrudRepository<Cinema, Long> {
    @RestResource(path="searchByName", rel="searchByName")
    List<Cinema> findByName(@Param("name") String name);
}
