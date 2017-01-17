package com.movierp.server.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Cesar
 */
@Entity
@Table(name = "RESERVAS", schema = "movierp", catalog = "")
public class ReservasEntity {
    private int idreserva;

    @Id
    @Column(name = "IDRESERVA")
    public int getIdreserva() {
        return idreserva;
    }

    public void setIdreserva(int idreserva) {
        this.idreserva = idreserva;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ReservasEntity that = (ReservasEntity) o;

        if (idreserva != that.idreserva) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return idreserva;
    }
}
