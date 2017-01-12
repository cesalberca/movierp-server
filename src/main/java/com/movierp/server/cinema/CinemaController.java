package com.movierp.server.cinema;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CinemaController {
    @RequestMapping("/create")
    @ResponseBody
    public String create(String name) {
        Cinema cinema;
        try {
            cinema = new Cinema(name);
            cinemaDao.save(cinema);
        }
        catch (Exception ex) {
            return "Error creating the cinema: " + ex.toString();
        }
        return "Cinema succesfully created! (id = " + cinema.getId() + ")";
    }

    @Autowired
    private CinemaDao cinemaDao;
}
