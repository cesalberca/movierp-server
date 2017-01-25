package com.movierp.server.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Table(name = "proveedores")
public class Provider implements Serializable {
    @Id
    @GeneratedValue
    @Column(name = "id_proveedor", nullable = false)
    private long idProveedor;

    @Column(name = "nombre_comercial")
    private String nombre_comerical;

    @Column(name = "nombre_fiscal")
    private String apellidos;

    @Column(name = "direccion")
    private String direccion;

    @Column(name = "cif")
    private String cif;
}
