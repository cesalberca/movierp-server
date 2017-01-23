package com.movierp.server.entities;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by Cesar
 */
@Entity
@Table(name = "peliculas", schema = "movierp", catalog = "")
public class PeliculasEntity {
    private long idPelicula;
    private String nombre;
    private String sinopsis;
    private Integer duracion;
    private Collection<SesionesEntity> sesionesByIdPelicula;

    @Id
    @Column(name = "id_pelicula", nullable = false)
    public long getIdPelicula() {
        return idPelicula;
    }

    public void setIdPelicula(long idPelicula) {
        this.idPelicula = idPelicula;
    }

    @Basic
    @Column(name = "nombre", nullable = true, length = 50)
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Basic
    @Column(name = "sinopsis", nullable = true, length = 500)
    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

    @Basic
    @Column(name = "duracion", nullable = true)
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

        if (idPelicula != that.idPelicula) return false;
        if (nombre != null ? !nombre.equals(that.nombre) : that.nombre != null) return false;
        if (sinopsis != null ? !sinopsis.equals(that.sinopsis) : that.sinopsis != null) return false;
        if (duracion != null ? !duracion.equals(that.duracion) : that.duracion != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (idPelicula ^ (idPelicula >>> 32));
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        result = 31 * result + (sinopsis != null ? sinopsis.hashCode() : 0);
        result = 31 * result + (duracion != null ? duracion.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "peliculasByIdPelicula")
    public Collection<SesionesEntity> getSesionesByIdPelicula() {
        return sesionesByIdPelicula;
    }

    public void setSesionesByIdPelicula(Collection<SesionesEntity> sesionesByIdPelicula) {
        this.sesionesByIdPelicula = sesionesByIdPelicula;
    }
}
