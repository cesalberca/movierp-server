package com.movierp.server.services;

import com.movierp.server.entities.Cinema;
import com.movierp.server.entities.CinemaRoom;
import com.movierp.server.entities.Session;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "cinemas", path = "cinemas")
public interface CinemaService extends CrudRepository<Cinema, Long> {
    @RestResource(path = "findByNombre")
    List<Cinema> findByNombre(@Param("nombre") String name);

    @Query("select s from Session s where s.idSala in (select idSala from CinemaRoom where idCine = :idCine)")
    List<Session> findSessionsByCinemaId(@Param("idCine") Long idCine);

//    @Query("select c from Cinema c where c.idCine = 44")
//    List<Cinema> findCinemas(@Param("idCine") long idCine);

//    @Query("SELECT c FROM Cinema c WHERE c.idCine = :idCine")
//    Cinema findCinema(@Param("idCine") Long idCine);

//    @Query("select c from CinemaRoom c")
//    List<CinemaRoom> findCinemaRoom();

    // Comentario para César:
    // Lo que estaría bien es que :
    // 1 - Le paso la id del Cine
    // 2 - Devuelve todas las sesiones del Cine con esa id
}
