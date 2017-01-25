package com.movierp.server.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
@Data
@Table(name = "productos", schema = "movierp")
public class ProductosEntity implements Serializable {
    @Id
    @GeneratedValue
    @Column(name = "id_producto", nullable = false)
    private long idProducto;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "precio")
    private Double precio;
}
