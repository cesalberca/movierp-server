package com.movierp.server.entities;

import javax.persistence.*;

/**
 * Created by Cesar
 */
@Entity
@Table(name = "reservas", schema = "movierp", catalog = "")
public class ReservasEntity {
    private long idReserva;
    private Long idVenta;
    private Long idSesion;
    private VentasEntity ventasByIdVenta;
    private SesionesEntity sesionesByIdSesion;

    @Id
    @Column(name = "id_reserva", nullable = false)
    public long getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(long idReserva) {
        this.idReserva = idReserva;
    }

    @Basic
    @Column(name = "id_venta", nullable = true)
    public Long getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(Long idVenta) {
        this.idVenta = idVenta;
    }

    @Basic
    @Column(name = "id_sesion", nullable = true)
    public Long getIdSesion() {
        return idSesion;
    }

    public void setIdSesion(Long idSesion) {
        this.idSesion = idSesion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ReservasEntity that = (ReservasEntity) o;

        if (idReserva != that.idReserva) return false;
        if (idVenta != null ? !idVenta.equals(that.idVenta) : that.idVenta != null) return false;
        if (idSesion != null ? !idSesion.equals(that.idSesion) : that.idSesion != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (idReserva ^ (idReserva >>> 32));
        result = 31 * result + (idVenta != null ? idVenta.hashCode() : 0);
        result = 31 * result + (idSesion != null ? idSesion.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "id_venta", referencedColumnName = "id_venta", insertable = false, updatable = false)
    public VentasEntity getVentasByIdVenta() {
        return ventasByIdVenta;
    }

    public void setVentasByIdVenta(VentasEntity ventasByIdVenta) {
        this.ventasByIdVenta = ventasByIdVenta;
    }

    @ManyToOne
    @JoinColumn(name = "id_sesion", referencedColumnName = "id_sesion", insertable = false, updatable = false)
    public SesionesEntity getSesionesByIdSesion() {
        return sesionesByIdSesion;
    }

    public void setSesionesByIdSesion(SesionesEntity sesionesByIdSesion) {
        this.sesionesByIdSesion = sesionesByIdSesion;
    }
}
