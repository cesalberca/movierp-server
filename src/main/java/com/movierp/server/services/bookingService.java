package com.movierp.server.services;

import com.movierp.server.entities.ReservasEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
@RepositoryRestResource(collectionResourceRel = "booking", path = "booking")
public interface bookingService extends CrudRepository<ReservasEntity, Long> {
}
