package com.movierp.server.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Cesar
 */
@Entity
@Table(name = "PEDIDOS", schema = "movierp", catalog = "")
public class PedidosEntity {
    private int idpedido;

    @Id
    @Column(name = "IDPEDIDO")
    public int getIdpedido() {
        return idpedido;
    }

    public void setIdpedido(int idpedido) {
        this.idpedido = idpedido;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PedidosEntity that = (PedidosEntity) o;

        if (idpedido != that.idpedido) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return idpedido;
    }
}
