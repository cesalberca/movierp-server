package com.movierp.server.services;


import com.movierp.server.entities.Session;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "sessions", path = "sessions")
public interface SessionService  extends CrudRepository<Session, Long>{
}
