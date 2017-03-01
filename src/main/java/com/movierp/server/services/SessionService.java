package com.movierp.server.services;


import com.movierp.server.entities.Session;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.transaction.annotation.Transactional;

@RepositoryRestResource(collectionResourceRel = "sessions", path = "sessions")
public interface SessionService  extends CrudRepository<Session, Long>{

    /**
     * Updates the available seats of a given session
     * @param idSesion the session to be updated
     * @param ticketAmount the amount of available seats to be subtracted
     */
    @Transactional
    @Modifying(clearAutomatically = true)
    @Query("update Session s set s.butacasLibres = s.butacasLibres - :ticketAmount where s.idSesion = :idSesion and s.butacasLibres - :ticketAmount >= 0")
    int buyTicketsForSessionById(@Param("idSesion") long idSesion, @Param("ticketAmount") int ticketAmount);
}
