package com.movierp.server.entities;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by Cesar
 */
@Entity
@Table(name = "pedidos", schema = "movierp", catalog = "")
public class PedidosEntity {
    private long idPedido;
    private Long idProveedor;
    private Collection<PedProdEntity> pedProdsByIdPedido;
    private ProveedoresEntity proveedoresByIdProveedor;

    @Id
    @Column(name = "id_pedido", nullable = false)
    public long getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(long idPedido) {
        this.idPedido = idPedido;
    }

    @Basic
    @Column(name = "id_proveedor", nullable = true)
    public Long getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(Long idProveedor) {
        this.idProveedor = idProveedor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PedidosEntity that = (PedidosEntity) o;

        if (idPedido != that.idPedido) return false;
        if (idProveedor != null ? !idProveedor.equals(that.idProveedor) : that.idProveedor != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (idPedido ^ (idPedido >>> 32));
        result = 31 * result + (idProveedor != null ? idProveedor.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "pedidosByIdPedido")
    public Collection<PedProdEntity> getPedProdsByIdPedido() {
        return pedProdsByIdPedido;
    }

    public void setPedProdsByIdPedido(Collection<PedProdEntity> pedProdsByIdPedido) {
        this.pedProdsByIdPedido = pedProdsByIdPedido;
    }

    @ManyToOne
    @JoinColumn(name = "id_proveedor", referencedColumnName = "id_proveedor", insertable = false, updatable = false)
    public ProveedoresEntity getProveedoresByIdProveedor() {
        return proveedoresByIdProveedor;
    }

    public void setProveedoresByIdProveedor(ProveedoresEntity proveedoresByIdProveedor) {
        this.proveedoresByIdProveedor = proveedoresByIdProveedor;
    }
}
