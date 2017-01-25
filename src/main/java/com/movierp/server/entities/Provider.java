package com.movierp.server.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
@Data
@Table(name = "proveedores")
public class Provider implements Serializable {
    @Id
    @GeneratedValue
    @Column(name = "id_proveedor", nullable = false)
    private long idProveedor;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellidos")
    private String apellidos;

    @Column(name = "cif")
    private String cif;
}
