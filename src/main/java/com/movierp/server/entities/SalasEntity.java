package com.movierp.server.entities;

import javax.persistence.*;

/**
 * Created by Cesar
 */
@Entity
@Table(name = "SALAS", schema = "movierp", catalog = "")
public class SalasEntity {
    private int idsala;
    private Integer numeroButacas;

    @Id
    @Column(name = "IDSALA")
    public int getIdsala() {
        return idsala;
    }

    public void setIdsala(int idsala) {
        this.idsala = idsala;
    }

    @Basic
    @Column(name = "NUMERO_BUTACAS")
    public Integer getNumeroButacas() {
        return numeroButacas;
    }

    public void setNumeroButacas(Integer numeroButacas) {
        this.numeroButacas = numeroButacas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SalasEntity that = (SalasEntity) o;

        if (idsala != that.idsala) return false;
        if (numeroButacas != null ? !numeroButacas.equals(that.numeroButacas) : that.numeroButacas != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idsala;
        result = 31 * result + (numeroButacas != null ? numeroButacas.hashCode() : 0);
        return result;
    }
}
