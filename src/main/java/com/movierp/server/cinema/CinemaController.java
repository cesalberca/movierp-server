package com.movierp.server.cinema;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping(value = "/cinemas")
public class CinemaController {
    private final CinemaService cinemaService;

    @Autowired
    public CinemaController(CinemaService cinemaService) {
        this.cinemaService = cinemaService;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Cinema> create(Cinema cinema) {
        this.cinemaService.save(cinema);
        HttpHeaders responseHeaders = new HttpHeaders();
        return new ResponseEntity<>(cinema, responseHeaders, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET)
    public Collection<Cinema> findAll() {
        return (Collection<Cinema>) this.cinemaService.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity findOne(@PathVariable("id") long id) {
        try {
            Cinema cinema = this.cinemaService.findOne(id);
            return new ResponseEntity<>(cinema, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(ex, HttpStatus.OK);
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Cinema> update(@PathVariable("id") Cinema cinema) {
        this.cinemaService.save(cinema);
        HttpHeaders responseHeaders = new HttpHeaders();
        return new ResponseEntity<>(cinema, responseHeaders, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") long id) {
        this.cinemaService.delete(id);
    }
}