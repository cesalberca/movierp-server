package com.movierp.server.services;

import com.movierp.server.entities.ProveedoresEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
@RepositoryRestResource(collectionResourceRel = "providers", path = "providers")
public interface ProviderService extends CrudRepository<ProveedoresEntity, Long> {
}
