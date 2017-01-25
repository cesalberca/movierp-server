package com.movierp.server.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
@Data
@Table(name = "peliculas")
public class Movie implements Serializable {
    @Id
    @GeneratedValue
    @Column(name = "id_pelicula", nullable = false)
    private long idPelicula;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "sinopsis")
    private String sinopsis;

    @Column(name = "duracion")
    private Integer duracion;
}
