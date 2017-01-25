package com.movierp.server.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Data
@Table(name = "ventas")
public class Sales implements Serializable {
    @Id
    @GeneratedValue
    @Column(name = "id_venta", nullable = false)
    private long idVenta;

    @Column(name = "fecha")
    private Date fecha;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Client client;
}
