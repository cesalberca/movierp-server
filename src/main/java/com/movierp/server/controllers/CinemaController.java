package com.movierp.server.controllers;

import com.movierp.server.entities.CinesEntity;
import com.movierp.server.services.CinemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
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

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<CinesEntity> create(CinesEntity cinema) {
        this.cinemaService.save(cinema);
        HttpHeaders responseHeaders = new HttpHeaders();
        return new ResponseEntity<>(cinema, responseHeaders, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET)
    public Collection<CinesEntity> findAll() {
        return (Collection<CinesEntity>) this.cinemaService.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity findOne(@PathVariable("id") long id) {
        try {
            CinesEntity cinema = this.cinemaService.findOne(id);
            return new ResponseEntity<>(cinema, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(ex, HttpStatus.OK);
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<CinesEntity> update(@PathVariable("id") CinesEntity cinema) {
        this.cinemaService.save(cinema);
        HttpHeaders responseHeaders = new HttpHeaders();
        return new ResponseEntity<>(cinema, responseHeaders, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") long id) {
        this.cinemaService.delete(id);
    }
}