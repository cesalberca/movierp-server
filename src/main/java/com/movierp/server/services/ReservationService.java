package com.movierp.server.services;

import com.movierp.server.entities.Reservation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "booking", path = "booking")
public interface ReservationService extends CrudRepository<Reservation, Long> {
}
