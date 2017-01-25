package com.movierp.server.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
@Table(name = "cines")
public class Cinema implements Serializable {
    @Id
    @GeneratedValue
    @Column(name = "id_cine", nullable = false)
    private long idCine;

    @Column(name = "cif")
    private String cif;

    @Column(name = "direccion")
    private String direccion;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "codigo_postal")
    private Integer codigoPostal;

    @OneToMany(mappedBy = "cinema")
    private List<CinemaRoom> cinemaRoom;
}
