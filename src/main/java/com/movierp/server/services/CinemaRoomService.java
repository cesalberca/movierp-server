package com.movierp.server.services;

import com.movierp.server.entities.Cinema;
import com.movierp.server.entities.CinemaRoom;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "rooms", path = "rooms")
public interface CinemaRoomService extends CrudRepository<CinemaRoom, Long> {
    @RestResource(path = "findByIdCine")
    List<CinemaRoom> findByIdCine(@Param("idCine") long idCine);
}
