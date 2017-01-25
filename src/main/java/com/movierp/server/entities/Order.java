package com.movierp.server.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Table(name = "pedidos")
public class Order implements Serializable {
    @Id
    @GeneratedValue
    @Column(name = "id_pedido", nullable = false)
    private long idPedido;

    @Column(name = "id_proveedor")
    private Long idProveedor;

//    @OneToOne
//    private Provider proveedoresEntity;
}
