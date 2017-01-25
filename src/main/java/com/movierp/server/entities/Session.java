package com.movierp.server.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.List;

@Entity
@Data
@Table(name = "sesiones")
public class Session implements Serializable {
    @Id
    @GeneratedValue
    @Column(name = "id_sesion", nullable = false)
    private long idSesion;

    @Column(name = "fecha_comienzo")
    private Date fechaComienzo;

    @OneToMany(mappedBy = "session")
    private List<Reservation> reservation;

    @ManyToOne
    @JoinColumn(name = "id_pelicula")
    private Movie movie;

    @ManyToOne
    @JoinColumn(name = "id_sala")
    private CinemaRoom cinemaRoom;

    @OneToOne
    @JoinColumn(name = "id_sesion")
    private Session session;
}
