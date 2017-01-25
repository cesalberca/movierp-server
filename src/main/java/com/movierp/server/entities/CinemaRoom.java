package com.movierp.server.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
@Table(name = "salas")
public class CinemaRoom implements Serializable {
    @Id
    @GeneratedValue
    @Column(name = "id_sala", nullable = false)
    private long idSala;

    @Column(name = "numero_butacas")
    private Integer numeroButacas;

//    @ManyToOne
//    @JoinColumn(name = "id_cine")
//    private Cinema cinema;
//
//    @OneToMany(mappedBy = "cinemaRoom")
//    private List<Session> sesiones;
}
