package com.movierp.server.services;


import com.movierp.server.entities.SesionesEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
@RepositoryRestResource(collectionResourceRel = "sessions", path = "sessions")
public interface SessionService  extends CrudRepository<SesionesEntity, Long>{
}
