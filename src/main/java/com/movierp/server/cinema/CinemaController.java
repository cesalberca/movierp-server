package com.movierp.server.cinema;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Cinema> create(@RequestBody Cinema cinema) {
        cinemaService.save(cinema);
        HttpHeaders responseHeaders = new HttpHeaders();
        return new ResponseEntity<>(cinema, responseHeaders, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Cinema> getCinemas() {
        return (List<Cinema>) cinemaService.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Cinema getCinema(@PathVariable("id") long id) {
        return cinemaService.findOne(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") long id) {
        cinemaService.delete(id);
    }
}
