package com.movierp.server.services;

import com.movierp.server.entities.Provider;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "providers", path = "providers")
public interface ProviderService extends CrudRepository<Provider, Long> {
}
