package com.movierp.server.controllers;

import com.movierp.server.entities.CinesEntity;
import com.movierp.server.services.CinemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping(value = "/cinemas")
public class CinemaController {
    private final CinemaService cinemaService;

    @Autowired
    public CinemaController(CinemaService cinemaService) {
        this.cinemaService = cinemaService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Collection<CinesEntity>> findAll() {
        Collection<CinesEntity> cinemas = (Collection<CinesEntity>) this.cinemaService.findAll();

        if (cinemas.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(cinemas, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<CinesEntity> findOne(@PathVariable("id") Long id) {
        CinesEntity cinema = this.cinemaService.findOne(id);
        return new ResponseEntity<>(cinema, HttpStatus.FOUND);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<CinesEntity> create(@RequestBody CinesEntity cinema) {
        this.cinemaService.save(cinema);
        return new ResponseEntity<>(cinema, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<CinesEntity> update(@PathVariable("id") Long id, @RequestBody CinesEntity cinema) {
        CinesEntity currentCinema = this.cinemaService.findOne(id);

        if (currentCinema == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        this.cinemaService.save(cinema);

        return new ResponseEntity<>(cinema, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<CinesEntity> delete(@PathVariable("id") Long id) {
        CinesEntity cinema = this.cinemaService.findOne(id);

        if (cinema == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        this.cinemaService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}