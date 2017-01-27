package com.movierp.server.projections;

import com.movierp.server.entities.Cinema;
import com.movierp.server.entities.CinemaRoom;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "inlineCinemaRoom", types = {Cinema.class})
public interface InlineCinemaRoom {
    String getCif();
    String getDireccion();
    String getNombre();
    String getIdCine();
    String getCodigoPostal();
//    CinemaRoom getCinemaRoom();
}
