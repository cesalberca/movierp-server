package com.movierp.server.services;

import com.movierp.server.entities.CinemaRoom;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
@RepositoryRestResource(collectionResourceRel = "rooms", path = "rooms")
public interface RoomService extends CrudRepository<CinemaRoom, Long> {
}
