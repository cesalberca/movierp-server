package com.movierp.server.entities;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "sesiones", schema = "movierp", catalog = "")
public class SesionesEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_sesion", nullable = false)
    private long idSesion;

    @Column(name = "fecha_comienzo")
    private Date fechaComienzo;

    @ManyToOne
    @JoinColumn(name = "id_pelicula")
    private PeliculasEntity peliculasEntity;

    @ManyToOne
    @JoinColumn(name = "id_sala")
    private SalasEntity salasEntity;

    @OneToMany(mappedBy = "reservasEntity")
    private List<ReservasEntity> reservasEntity;

    public SesionesEntity() {
    }
}
