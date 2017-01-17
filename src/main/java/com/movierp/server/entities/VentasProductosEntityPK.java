package com.movierp.server.entities;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by Cesar
 */
public class VentasProductosEntityPK implements Serializable {
    private int idventa;
    private int idproducto;

    @Column(name = "IDVENTA")
    @Id
    public int getIdventa() {
        return idventa;
    }

    public void setIdventa(int idventa) {
        this.idventa = idventa;
    }

    @Column(name = "IDPRODUCTO")
    @Id
    public int getIdproducto() {
        return idproducto;
    }

    public void setIdproducto(int idproducto) {
        this.idproducto = idproducto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        VentasProductosEntityPK that = (VentasProductosEntityPK) o;

        if (idventa != that.idventa) return false;
        if (idproducto != that.idproducto) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idventa;
        result = 31 * result + idproducto;
        return result;
    }
}
