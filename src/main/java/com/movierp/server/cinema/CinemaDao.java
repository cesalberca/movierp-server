package com.movierp.server.cinema;

import javax.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;

@Transactional
public interface CinemaDao extends CrudRepository<Cinema, Long> {
}

