package com.movierp.server.entities;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "proveedores", schema = "movierp")
public class ProveedoresEntity {
    @Id
    @Column(name = "id_proveedor", nullable = false)
    private long idProveedor;
    private String nombre;
    private String apellidos;
    private String cif;

    public long getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(long idProveedor) {
        this.idProveedor = idProveedor;
    }

    @Column(name = "nombre", nullable = true, length = 100)
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Column(name = "apellidos", nullable = true, length = 100)
    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    @Column(name = "cif", nullable = true, length = 9)
    public String getCif() {
        return cif;
    }

    public void setCif(String cif) {
        this.cif = cif;
    }
}
