package com.movierp.server.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
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

    public ReservasEntity() {
    }

    public ReservasEntity(VentasEntity ventasEntity, SesionesEntity sesionesEntity) {
        this.ventasEntity = ventasEntity;
        this.sesionesEntity = sesionesEntity ;
    }

    public long getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(long idReserva) {
        this.idReserva = idReserva;
    }

    public VentasEntity getVentasEntity() {
        return ventasEntity;
    }

    public void setVentasEntity(VentasEntity ventasByIdVenta) {
        this.ventasEntity = ventasByIdVenta;
    }

    public SesionesEntity getSesionesEntity() {
        return sesionesEntity;
    }

    public void setSesionesEntity(SesionesEntity sesionesEntity) {
        this.sesionesEntity = sesionesEntity;
    }
}
