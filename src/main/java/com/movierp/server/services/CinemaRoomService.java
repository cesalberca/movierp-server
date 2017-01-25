package com.movierp.server.services;

import com.movierp.server.entities.CinemaRoom;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "rooms", path = "rooms")
public interface CinemaRoomService extends CrudRepository<CinemaRoom, Long> {
}
