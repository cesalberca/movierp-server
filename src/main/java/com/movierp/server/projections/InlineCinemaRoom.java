package com.movierp.server.projections;

import com.movierp.server.entities.CinesEntity;
import com.movierp.server.entities.SalasEntity;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "inlineCinemaRoom", types = {CinesEntity.class})
public interface InlineCinemaRoom {
    String getCif();
    String getDireccion();
    String getNombre();
    String getIdCine();
    String getCodigoPostal();
    SalasEntity getSalasEntity();
}
