package com.movierp.server.entities;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;

/**
 * Created by Cesar
 */
@Entity
@Table(name = "ventas", schema = "movierp", catalog = "")
public class VentasEntity {
    private long idVenta;
    private Date fecha;
    private Long idCliente;
    private Collection<ReservasEntity> reservassByIdVenta;
    private ClientesEntity clientesByIdCliente;
    private Collection<VentasProductosEntity> ventasProductossByIdVenta;

    @Id
    @Column(name = "id_venta", nullable = false)
    public long getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(long idVenta) {
        this.idVenta = idVenta;
    }

    @Basic
    @Column(name = "fecha", nullable = true)
    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Basic
    @Column(name = "id_cliente", nullable = true)
    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        VentasEntity that = (VentasEntity) o;

        if (idVenta != that.idVenta) return false;
        if (fecha != null ? !fecha.equals(that.fecha) : that.fecha != null) return false;
        if (idCliente != null ? !idCliente.equals(that.idCliente) : that.idCliente != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (idVenta ^ (idVenta >>> 32));
        result = 31 * result + (fecha != null ? fecha.hashCode() : 0);
        result = 31 * result + (idCliente != null ? idCliente.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "ventasEntity")
    public Collection<ReservasEntity> getReservassByIdVenta() {
        return reservassByIdVenta;
    }

    public void setReservassByIdVenta(Collection<ReservasEntity> reservassByIdVenta) {
        this.reservassByIdVenta = reservassByIdVenta;
    }

    @ManyToOne
    @JoinColumn(name = "id_cliente", referencedColumnName = "id_cliente", insertable = false, updatable = false)
    public ClientesEntity getClientesByIdCliente() {
        return clientesByIdCliente;
    }

    public void setClientesByIdCliente(ClientesEntity clientesByIdCliente) {
        this.clientesByIdCliente = clientesByIdCliente;
    }

    @OneToMany(mappedBy = "ventasByIdVenta")
    public Collection<VentasProductosEntity> getVentasProductossByIdVenta() {
        return ventasProductossByIdVenta;
    }

    public void setVentasProductossByIdVenta(Collection<VentasProductosEntity> ventasProductossByIdVenta) {
        this.ventasProductossByIdVenta = ventasProductossByIdVenta;
    }
}
