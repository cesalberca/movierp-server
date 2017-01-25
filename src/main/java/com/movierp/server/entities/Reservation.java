package com.movierp.server.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Table(name = "reservas")
public class Reservation implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_reserva", nullable = false)
    private long idReserva;

//    @ManyToOne
//    @JoinColumn(name = "id_sesion")
//    private Session session;
//
//    @ManyToOne
//    @JoinColumn(name = "id_venta")
//    private Sales sales;
}
