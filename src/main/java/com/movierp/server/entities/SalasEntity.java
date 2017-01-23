package com.movierp.server.entities;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by Cesar
 */
@Entity
@Table(name = "salas", schema = "movierp", catalog = "")
public class SalasEntity {
    private long idSala;
    private Integer numeroButacas;
    private long idCine;
    private CinesEntity cinesByIdCine;
    private Collection<SesionesEntity> sesionesByIdSala;

    @Id
    @Column(name = "id_sala", nullable = false)
    public long getIdSala() {
        return idSala;
    }

    public void setIdSala(long idSala) {
        this.idSala = idSala;
    }

    @Basic
    @Column(name = "numero_butacas", nullable = true)
    public Integer getNumeroButacas() {
        return numeroButacas;
    }

    public void setNumeroButacas(Integer numeroButacas) {
        this.numeroButacas = numeroButacas;
    }

    @Basic
    @Column(name = "id_cine", nullable = false)
    public long getIdCine() {
        return idCine;
    }

    public void setIdCine(long idCine) {
        this.idCine = idCine;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SalasEntity that = (SalasEntity) o;

        if (idSala != that.idSala) return false;
        if (idCine != that.idCine) return false;
        if (numeroButacas != null ? !numeroButacas.equals(that.numeroButacas) : that.numeroButacas != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (idSala ^ (idSala >>> 32));
        result = 31 * result + (numeroButacas != null ? numeroButacas.hashCode() : 0);
        result = 31 * result + (int) (idCine ^ (idCine >>> 32));
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "id_cine", referencedColumnName = "id_cine", nullable = false, insertable = false, updatable = false)
    public CinesEntity getCinesByIdCine() {
        return cinesByIdCine;
    }

    public void setCinesByIdCine(CinesEntity cinesByIdCine) {
        this.cinesByIdCine = cinesByIdCine;
    }

    @OneToMany(mappedBy = "salasByIdSala")
    public Collection<SesionesEntity> getSesionesByIdSala() {
        return sesionesByIdSala;
    }

    public void setSesionesByIdSala(Collection<SesionesEntity> sesionesByIdSala) {
        this.sesionesByIdSala = sesionesByIdSala;
    }
}
