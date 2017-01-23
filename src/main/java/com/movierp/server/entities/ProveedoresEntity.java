package com.movierp.server.entities;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by Cesar
 */
@Entity
@Table(name = "proveedores", schema = "movierp", catalog = "")
public class ProveedoresEntity {
    private long idProveedor;
    private String nombre;
    private String apellidos;
    private String cif;
    private Collection<PedidosEntity> pedidossByIdProveedor;

    @Id
    @Column(name = "id_proveedor", nullable = false)
    public long getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(long idProveedor) {
        this.idProveedor = idProveedor;
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
    @Column(name = "apellidos", nullable = true, length = 100)
    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    @Basic
    @Column(name = "cif", nullable = true, length = 9)
    public String getCif() {
        return cif;
    }

    public void setCif(String cif) {
        this.cif = cif;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProveedoresEntity that = (ProveedoresEntity) o;

        if (idProveedor != that.idProveedor) return false;
        if (nombre != null ? !nombre.equals(that.nombre) : that.nombre != null) return false;
        if (apellidos != null ? !apellidos.equals(that.apellidos) : that.apellidos != null) return false;
        if (cif != null ? !cif.equals(that.cif) : that.cif != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (idProveedor ^ (idProveedor >>> 32));
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        result = 31 * result + (apellidos != null ? apellidos.hashCode() : 0);
        result = 31 * result + (cif != null ? cif.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "proveedoresByIdProveedor")
    public Collection<PedidosEntity> getPedidossByIdProveedor() {
        return pedidossByIdProveedor;
    }

    public void setPedidossByIdProveedor(Collection<PedidosEntity> pedidossByIdProveedor) {
        this.pedidossByIdProveedor = pedidossByIdProveedor;
    }
}
