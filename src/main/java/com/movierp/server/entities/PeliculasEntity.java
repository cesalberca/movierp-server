package com.movierp.server.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
@Table(name = "peliculas", schema = "movierp")
public class PeliculasEntity implements Serializable {
    @Id
    @Column(name = "id_pelicula", nullable = false)
    private long idPelicula;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "sinopsis")
    private String sinopsis;

    @Column(name = "duracion")
    private Integer duracion;

    public long getIdPelicula() {
        return idPelicula;
    }

    public void setIdPelicula(long idPelicula) {
        this.idPelicula = idPelicula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

    public Integer getDuracion() {
        return duracion;
    }

    public void setDuracion(Integer duracion) {
        this.duracion = duracion;
    }
}
