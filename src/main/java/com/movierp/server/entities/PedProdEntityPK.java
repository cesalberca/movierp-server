package com.movierp.server.entities;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by Cesar
 */
public class PedProdEntityPK implements Serializable {
    private int idpedido;
    private int idproducto;

    @Column(name = "IDPEDIDO")
    @Id
    public int getIdpedido() {
        return idpedido;
    }

    public void setIdpedido(int idpedido) {
        this.idpedido = idpedido;
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

        PedProdEntityPK that = (PedProdEntityPK) o;

        if (idpedido != that.idpedido) return false;
        if (idproducto != that.idproducto) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idpedido;
        result = 31 * result + idproducto;
        return result;
    }
}
