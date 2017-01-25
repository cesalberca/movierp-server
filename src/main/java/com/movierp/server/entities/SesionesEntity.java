package com.movierp.server.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.List;

@Entity
@Data
@Table(name = "sesiones", schema = "movierp")
public class SesionesEntity implements Serializable {
    @Id
    @GeneratedValue
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

    @OneToOne
    @JoinColumn(name = "id_sesion")
    private SesionesEntity sesionesEntity;
}
