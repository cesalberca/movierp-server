package com.movierp.server.cinema;

import javax.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Transactional
@Repository
public interface CinemaDao extends CrudRepository<Cinema, Long> {
}
