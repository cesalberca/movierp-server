package com.movierp.server.entities;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by Cesar
 */
public class VentasProductosEntityPK implements Serializable {
    private long idVenta;
    private long idProducto;

    @Column(name = "id_venta", nullable = false)
    @Id
    public long getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(long idVenta) {
        this.idVenta = idVenta;
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

        VentasProductosEntityPK that = (VentasProductosEntityPK) o;

        if (idVenta != that.idVenta) return false;
        if (idProducto != that.idProducto) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (idVenta ^ (idVenta >>> 32));
        result = 31 * result + (int) (idProducto ^ (idProducto >>> 32));
        return result;
    }
}
