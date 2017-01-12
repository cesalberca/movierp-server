package com.movierp.server.cinema;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CinemaController {
    @Autowired
    public CinemaController(CinemaDao cinemaDao) {
        this.cinemaDao = cinemaDao;
    }

    @RequestMapping("/create")
    @ResponseBody
    public String create(String name, String cif, String address, String postalCode) {
        Cinema cinema;
        try {
            cinema = new Cinema(name, cif, address, postalCode);
            cinemaDao.save(cinema);
        }
        catch (Exception ex) {
            return "Error creating the cinema: " + ex.toString();
        }
        return "Cinema succesfully created! (id = " + cinema.getId() + ")";
    }

    private final CinemaDao cinemaDao;
}
