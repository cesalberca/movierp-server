package com.movierp.server.entities;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by Cesar
 */
@Entity
@Table(name = "VENTAS", schema = "movierp", catalog = "")
public class VentasEntity {
    private int idventa;
    private Date fecha;

    @Id
    @Column(name = "IDVENTA")
    public int getIdventa() {
        return idventa;
    }

    public void setIdventa(int idventa) {
        this.idventa = idventa;
    }

    @Basic
    @Column(name = "FECHA")
    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        VentasEntity that = (VentasEntity) o;

        if (idventa != that.idventa) return false;
        if (fecha != null ? !fecha.equals(that.fecha) : that.fecha != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idventa;
        result = 31 * result + (fecha != null ? fecha.hashCode() : 0);
        return result;
    }
}
