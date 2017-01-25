package com.movierp.server.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
@Data
@Table(name = "pedidos", schema = "movierp")
public class PedidosEntity implements Serializable {
    @Id
    @GeneratedValue
    @Column(name = "id_pedido", nullable = false)
    private long idPedido;

    @Column(name = "id_proveedor")
    private Long idProveedor;

//    @OneToOne
//    private ProveedoresEntity proveedoresEntity;
}
