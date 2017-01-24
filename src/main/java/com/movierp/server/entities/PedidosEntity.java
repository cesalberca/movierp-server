package com.movierp.server.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
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

    public PedidosEntity() {
    }

    public PedidosEntity(Long idProveedor) {
        this.idProveedor = idProveedor;
    }

    public long getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(long idPedido) {
        this.idPedido = idPedido;
    }

    public Long getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(Long idProveedor) {
        this.idProveedor = idProveedor;
    }
}
