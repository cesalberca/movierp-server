package com.movierp.server.services;

import com.movierp.server.entities.Cinema;
import com.movierp.server.entities.Movie;
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

    /**
     * Returns all the movies that a cinema with a given id is showing
     * @param idCine the id of the cinema to check
     * @return a list of movies available in the cinema
     */
    @Query("select m from Movie m where m.idPelicula in (select idPelicula from Session where idSala in (select idSala from CinemaRoom where idCine = :idCine))")
    List<Movie> findMoviesByCinemaId(@Param("idCine") Long idCine);

    /**
     * Returns all the sessions of a given movie id in a given cinema id
     * @param idCine the id of the cinema to check
     * @param idPelicula the id of the movie to check
     * @return a list of available sessions of a given movie in a given cinema
     */
    @Query("select s from Session s where s.idSala in (select idSala from CinemaRoom where idCine = :idCine) and s.idPelicula = :idPelicula")
    List<Session> findSessionsByCinemaIdAndByMovieId(@Param("idCine") Long idCine, @Param("idPelicula") Long idPelicula);

}
