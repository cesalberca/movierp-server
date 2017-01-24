package com.movierp.server.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
@Table(name = "pedidos", schema = "movierp")
public class PedidosEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_pedido", nullable = false)
    private long idPedido;

    @Column(name = "id_proveedor")
    private Long idProveedor;

    @ManyToOne
    @JoinColumn(name = "id_proveedor", referencedColumnName = "id_proveedor", insertable = false, updatable = false)
    private ProveedoresEntity proveedoresByIdProveedor;

    public PedidosEntity() {
    }

    public PedidosEntity(Long idProveedor, ProveedoresEntity proveedoresByIdProveedor) {
        this.idProveedor = idProveedor;
        this.proveedoresByIdProveedor = proveedoresByIdProveedor;
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

    public ProveedoresEntity getProveedoresByIdProveedor() {
        return proveedoresByIdProveedor;
    }

    public void setProveedoresByIdProveedor(ProveedoresEntity proveedoresByIdProveedor) {
        this.proveedoresByIdProveedor = proveedoresByIdProveedor;
    }
}
