package com.movierp.server.entities;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by Cesar
 */
@Entity
@Table(name = "SESIONES", schema = "movierp", catalog = "")
public class SesionesEntity {
    private int idsesion;
    private Date fechaComienzo;

    @Id
    @Column(name = "IDSESION")
    public int getIdsesion() {
        return idsesion;
    }

    public void setIdsesion(int idsesion) {
        this.idsesion = idsesion;
    }

    @Basic
    @Column(name = "FECHA_COMIENZO")
    public Date getFechaComienzo() {
        return fechaComienzo;
    }

    public void setFechaComienzo(Date fechaComienzo) {
        this.fechaComienzo = fechaComienzo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SesionesEntity that = (SesionesEntity) o;

        if (idsesion != that.idsesion) return false;
        if (fechaComienzo != null ? !fechaComienzo.equals(that.fechaComienzo) : that.fechaComienzo != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idsesion;
        result = 31 * result + (fechaComienzo != null ? fechaComienzo.hashCode() : 0);
        return result;
    }
}
