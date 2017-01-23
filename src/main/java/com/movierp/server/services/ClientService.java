package com.movierp.server.services;

import com.movierp.server.entities.ClientesEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
@RepositoryRestResource(collectionResourceRel = "clients", path = "clients")
public interface ClientService extends CrudRepository<ClientesEntity, Long> {
}
