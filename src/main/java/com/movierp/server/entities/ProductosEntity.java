package com.movierp.server.entities;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by Cesar
 */
@Entity
@Table(name = "productos", schema = "movierp", catalog = "")
public class ProductosEntity {
    private long idProducto;
    private String nombre;
    private Double precio;
    private Collection<PedProdEntity> pedProdsByIdProducto;
    private Collection<VentasProductosEntity> ventasProductossByIdProducto;

    @Id
    @Column(name = "id_producto", nullable = false)
    public long getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(long idProducto) {
        this.idProducto = idProducto;
    }

    @Basic
    @Column(name = "nombre", nullable = true, length = 100)
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Basic
    @Column(name = "precio", nullable = true, precision = 0)
    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProductosEntity that = (ProductosEntity) o;

        if (idProducto != that.idProducto) return false;
        if (nombre != null ? !nombre.equals(that.nombre) : that.nombre != null) return false;
        if (precio != null ? !precio.equals(that.precio) : that.precio != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (idProducto ^ (idProducto >>> 32));
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        result = 31 * result + (precio != null ? precio.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "productosByIdProducto")
    public Collection<PedProdEntity> getPedProdsByIdProducto() {
        return pedProdsByIdProducto;
    }

    public void setPedProdsByIdProducto(Collection<PedProdEntity> pedProdsByIdProducto) {
        this.pedProdsByIdProducto = pedProdsByIdProducto;
    }

    @OneToMany(mappedBy = "productosByIdProducto")
    public Collection<VentasProductosEntity> getVentasProductossByIdProducto() {
        return ventasProductossByIdProducto;
    }

    public void setVentasProductossByIdProducto(Collection<VentasProductosEntity> ventasProductossByIdProducto) {
        this.ventasProductossByIdProducto = ventasProductossByIdProducto;
    }
}
