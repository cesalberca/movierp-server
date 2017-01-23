package com.movierp.server.entities;

import javax.persistence.*;

/**
 * Created by Cesar
 */
@Entity
@Table(name = "ventas_productos", schema = "movierp", catalog = "")
@IdClass(VentasProductosEntityPK.class)
public class VentasProductosEntity {
    private long idVenta;
    private long idProducto;
    private VentasEntity ventasByIdVenta;
    private ProductosEntity productosByIdProducto;

    @Id
    @Column(name = "id_venta", nullable = false)
    public long getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(long idVenta) {
        this.idVenta = idVenta;
    }

    @Id
    @Column(name = "id_producto", nullable = false)
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

        VentasProductosEntity that = (VentasProductosEntity) o;

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

    @ManyToOne
    @JoinColumn(name = "id_venta", referencedColumnName = "id_venta", nullable = false, insertable = false, updatable = false)
    public VentasEntity getVentasByIdVenta() {
        return ventasByIdVenta;
    }

    public void setVentasByIdVenta(VentasEntity ventasByIdVenta) {
        this.ventasByIdVenta = ventasByIdVenta;
    }

    @ManyToOne
    @JoinColumn(name = "id_producto", referencedColumnName = "id_producto", nullable = false, insertable = false, updatable = false)
    public ProductosEntity getProductosByIdProducto() {
        return productosByIdProducto;
    }

    public void setProductosByIdProducto(ProductosEntity productosByIdProducto) {
        this.productosByIdProducto = productosByIdProducto;
    }
}
