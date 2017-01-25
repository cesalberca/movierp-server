package com.movierp.server.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Table(name = "reservas", schema = "movierp")
public class ReservasEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_reserva", nullable = false)
    private long idReserva;

    @ManyToOne
    @JoinColumn(name = "id_sesion")
    private SesionesEntity sesionesEntity;

    @ManyToOne
    @JoinColumn(name = "id_venta")
    private VentasEntity ventasEntity;
}
