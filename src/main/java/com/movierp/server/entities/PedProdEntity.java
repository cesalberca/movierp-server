package com.movierp.server.entities;

import javax.persistence.*;

/**
 * Created by Cesar
 */
@Entity
@Table(name = "PED_PROD", schema = "movierp", catalog = "")
@IdClass(PedProdEntityPK.class)
public class PedProdEntity {
    private int idpedido;
    private int idproducto;
    private Integer cantidad;

    @Id
    @Column(name = "IDPEDIDO")
    public int getIdpedido() {
        return idpedido;
    }

    public void setIdpedido(int idpedido) {
        this.idpedido = idpedido;
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

        PedProdEntity that = (PedProdEntity) o;

        if (idpedido != that.idpedido) return false;
        if (idproducto != that.idproducto) return false;
        if (cantidad != null ? !cantidad.equals(that.cantidad) : that.cantidad != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idpedido;
        result = 31 * result + idproducto;
        result = 31 * result + (cantidad != null ? cantidad.hashCode() : 0);
        return result;
    }
}
