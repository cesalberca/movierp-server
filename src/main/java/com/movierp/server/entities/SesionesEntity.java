package com.movierp.server.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "sesiones", schema = "movierp")
public class SesionesEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_sesion", nullable = false)
    private long idSesion;

    @Column(name = "fecha_comienzo")
    private Date fechaComienzo;

    @OneToMany(mappedBy = "sesionesEntity")
    private List<ReservasEntity> reservasEntity;

    @ManyToOne
    @JoinColumn(name = "id_pelicula")
    private PeliculasEntity peliculasEntity;

    @ManyToOne
    @JoinColumn(name = "id_sala")
    private SalasEntity salasEntity;


    public SesionesEntity() {
    }

    public SesionesEntity(Date fechaComienzo, PeliculasEntity peliculasEntity, SalasEntity salasEntity, List<ReservasEntity> reservasEntity) {
        this.fechaComienzo = fechaComienzo;
        this.peliculasEntity = peliculasEntity;
        this.salasEntity = salasEntity;
        this.reservasEntity = reservasEntity;
    }

    public long getIdSesion() {
        return idSesion;
    }

    public Date getFechaComienzo() {
        return fechaComienzo;
    }

    public void setFechaComienzo(Date fechaComienzo) {
        this.fechaComienzo = fechaComienzo;
    }

    public PeliculasEntity getPeliculasEntity() {
        return peliculasEntity;
    }

    public void setPeliculasEntity(PeliculasEntity peliculasEntity) {
        this.peliculasEntity = peliculasEntity;
    }

    public SalasEntity getSalasEntity() {
        return salasEntity;
    }

    public void setSalasEntity(SalasEntity salasEntity) {
        this.salasEntity = salasEntity;
    }

    public List<ReservasEntity> getReservasEntity() {
        return reservasEntity;
    }

    public void setReservasEntity(List<ReservasEntity> reservasEntity) {
        this.reservasEntity = reservasEntity;
    }
}
