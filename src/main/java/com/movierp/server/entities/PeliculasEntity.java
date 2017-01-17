package com.movierp.server.entities;

import javax.persistence.*;

/**
 * Created by Cesar
 */
@Entity
@Table(name = "PELICULAS", schema = "movierp", catalog = "")
public class PeliculasEntity {
    private int idpelicula;
    private String nombre;
    private String sinopsis;
    private Integer duracion;

    @Id
    @Column(name = "IDPELICULA")
    public int getIdpelicula() {
        return idpelicula;
    }

    public void setIdpelicula(int idpelicula) {
        this.idpelicula = idpelicula;
    }

    @Basic
    @Column(name = "NOMBRE")
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Basic
    @Column(name = "SINOPSIS")
    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

    @Basic
    @Column(name = "DURACION")
    public Integer getDuracion() {
        return duracion;
    }

    public void setDuracion(Integer duracion) {
        this.duracion = duracion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PeliculasEntity that = (PeliculasEntity) o;

        if (idpelicula != that.idpelicula) return false;
        if (nombre != null ? !nombre.equals(that.nombre) : that.nombre != null) return false;
        if (sinopsis != null ? !sinopsis.equals(that.sinopsis) : that.sinopsis != null) return false;
        if (duracion != null ? !duracion.equals(that.duracion) : that.duracion != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idpelicula;
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        result = 31 * result + (sinopsis != null ? sinopsis.hashCode() : 0);
        result = 31 * result + (duracion != null ? duracion.hashCode() : 0);
        return result;
    }
}
