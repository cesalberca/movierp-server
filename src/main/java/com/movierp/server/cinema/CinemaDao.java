package com.movierp.server.cinema;

import javax.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.stereotype.Repository;

import java.util.List;

@Transactional
@RepositoryRestResource(path = "cinemas")
public interface CinemaDao extends CrudRepository<Cinema, Long> {
    @RestResource(path = "names", rel ="name")
    List<Cinema> findByName(String name);
}
