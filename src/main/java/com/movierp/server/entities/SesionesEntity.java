package com.movierp.server.entities;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;

/**
 * Created by Cesar
 */
@Entity
@Table(name = "sesiones", schema = "movierp", catalog = "")
public class SesionesEntity {
    private long idSesion;
    private Long idPelicula;
    private Long idSala;
    private Date fechaComienzo;
    private Collection<ReservasEntity> reservassByIdSesion;
    private PeliculasEntity peliculasByIdPelicula;
    private SalasEntity salasByIdSala;

    @Id
    @Column(name = "id_sesion", nullable = false)
    public long getIdSesion() {
        return idSesion;
    }

    public void setIdSesion(long idSesion) {
        this.idSesion = idSesion;
    }

    @Basic
    @Column(name = "id_pelicula", nullable = true)
    public Long getIdPelicula() {
        return idPelicula;
    }

    public void setIdPelicula(Long idPelicula) {
        this.idPelicula = idPelicula;
    }

    @Basic
    @Column(name = "id_sala", nullable = true)
    public Long getIdSala() {
        return idSala;
    }

    public void setIdSala(Long idSala) {
        this.idSala = idSala;
    }

    @Basic
    @Column(name = "fecha_comienzo", nullable = true)
    public Date getFechaComienzo() {
        return fechaComienzo;
    }

    public void setFechaComienzo(Date fechaComienzo) {
        this.fechaComienzo = fechaComienzo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SesionesEntity that = (SesionesEntity) o;

        if (idSesion != that.idSesion) return false;
        if (idPelicula != null ? !idPelicula.equals(that.idPelicula) : that.idPelicula != null) return false;
        if (idSala != null ? !idSala.equals(that.idSala) : that.idSala != null) return false;
        if (fechaComienzo != null ? !fechaComienzo.equals(that.fechaComienzo) : that.fechaComienzo != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (idSesion ^ (idSesion >>> 32));
        result = 31 * result + (idPelicula != null ? idPelicula.hashCode() : 0);
        result = 31 * result + (idSala != null ? idSala.hashCode() : 0);
        result = 31 * result + (fechaComienzo != null ? fechaComienzo.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "sesionesByIdSesion")
    public Collection<ReservasEntity> getReservassByIdSesion() {
        return reservassByIdSesion;
    }

    public void setReservassByIdSesion(Collection<ReservasEntity> reservassByIdSesion) {
        this.reservassByIdSesion = reservassByIdSesion;
    }

    @ManyToOne
    @JoinColumn(name = "id_pelicula", referencedColumnName = "id_pelicula", insertable = false, updatable = false)
    public PeliculasEntity getPeliculasByIdPelicula() {
        return peliculasByIdPelicula;
    }

    public void setPeliculasByIdPelicula(PeliculasEntity peliculasByIdPelicula) {
        this.peliculasByIdPelicula = peliculasByIdPelicula;
    }

    @ManyToOne
    @JoinColumn(name = "id_sala", referencedColumnName = "id_sala", insertable = false, updatable = false)
    public SalasEntity getSalasByIdSala() {
        return salasByIdSala;
    }

    public void setSalasByIdSala(SalasEntity salasByIdSala) {
        this.salasByIdSala = salasByIdSala;
    }
}
