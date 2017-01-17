package com.movierp.server.entities;

import javax.persistence.*;

/**
 * Created by Cesar
 */
@Entity
@Table(name = "VENTAS_PRODUCTOS", schema = "movierp", catalog = "")
@IdClass(VentasProductosEntityPK.class)
public class VentasProductosEntity {
    private int idventa;
    private int idproducto;
    private Integer cantidad;

    @Id
    @Column(name = "IDVENTA")
    public int getIdventa() {
        return idventa;
    }

    public void setIdventa(int idventa) {
        this.idventa = idventa;
    }

    @Id
    @Column(name = "IDPRODUCTO")
    public int getIdproducto() {
        return idproducto;
    }

    public void setIdproducto(int idproducto) {
        this.idproducto = idproducto;
    }

    @Basic
    @Column(name = "CANTIDAD")
    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        VentasProductosEntity that = (VentasProductosEntity) o;

        if (idventa != that.idventa) return false;
        if (idproducto != that.idproducto) return false;
        if (cantidad != null ? !cantidad.equals(that.cantidad) : that.cantidad != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idventa;
        result = 31 * result + idproducto;
        result = 31 * result + (cantidad != null ? cantidad.hashCode() : 0);
        return result;
    }
}
