package com.movierp.server.services;

import javax.transaction.Transactional;

import com.movierp.server.entities.CinesEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Transactional
@Repository
@RepositoryRestResource(collectionResourceRel = "cinemas", path = "cinemas")
public interface CinemaService extends CrudRepository<CinesEntity, Long> {
    @RestResource(path = "findByNombre")
    List<CinesEntity> findByNombre(@Param("nombre") String name);
}
