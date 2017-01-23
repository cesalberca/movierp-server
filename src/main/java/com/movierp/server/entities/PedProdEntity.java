package com.movierp.server.entities;

import javax.persistence.*;

/**
 * Created by Cesar
 */
@Entity
@Table(name = "ped_prod", schema = "movierp", catalog = "")
@IdClass(PedProdEntityPK.class)
public class PedProdEntity {
    private long idPedido;
    private long idProducto;
    private Integer cantidad;
    private PedidosEntity pedidosByIdPedido;
    private ProductosEntity productosByIdProducto;

    @Id
    @Column(name = "id_pedido", nullable = false)
    public long getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(long idPedido) {
        this.idPedido = idPedido;
    }

    @Id
    @Column(name = "id_producto", nullable = false)
    public long getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(long idProducto) {
        this.idProducto = idProducto;
    }

    @Basic
    @Column(name = "cantidad", nullable = true)
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

        if (idPedido != that.idPedido) return false;
        if (idProducto != that.idProducto) return false;
        if (cantidad != null ? !cantidad.equals(that.cantidad) : that.cantidad != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (idPedido ^ (idPedido >>> 32));
        result = 31 * result + (int) (idProducto ^ (idProducto >>> 32));
        result = 31 * result + (cantidad != null ? cantidad.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "id_pedido", referencedColumnName = "id_pedido", nullable = false, insertable = false, updatable = false)
    public PedidosEntity getPedidosByIdPedido() {
        return pedidosByIdPedido;
    }

    public void setPedidosByIdPedido(PedidosEntity pedidosByIdPedido) {
        this.pedidosByIdPedido = pedidosByIdPedido;
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
