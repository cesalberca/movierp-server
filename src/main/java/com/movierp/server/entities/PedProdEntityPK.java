package com.movierp.server.entities;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by Cesar
 */
public class PedProdEntityPK implements Serializable {
    private long idPedido;
    private long idProducto;

    @Column(name = "id_pedido", nullable = false)
    @Id
    public long getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(long idPedido) {
        this.idPedido = idPedido;
    }

    @Column(name = "id_producto", nullable = false)
    @Id
    public long getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(long idProducto) {
        this.idProducto = idProducto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PedProdEntityPK that = (PedProdEntityPK) o;

        if (idPedido != that.idPedido) return false;
        if (idProducto != that.idProducto) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (idPedido ^ (idPedido >>> 32));
        result = 31 * result + (int) (idProducto ^ (idProducto >>> 32));
        return result;
    }
}
