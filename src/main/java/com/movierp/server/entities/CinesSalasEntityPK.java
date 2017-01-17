package com.movierp.server.entities;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by Cesar
 */
public class CinesSalasEntityPK implements Serializable {
    private int idcine;
    private int idsala;

    @Column(name = "IDCINE")
    @Id
    public int getIdcine() {
        return idcine;
    }

    public void setIdcine(int idcine) {
        this.idcine = idcine;
    }

    @Column(name = "IDSALA")
    @Id
    public int getIdsala() {
        return idsala;
    }

    public void setIdsala(int idsala) {
        this.idsala = idsala;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CinesSalasEntityPK that = (CinesSalasEntityPK) o;

        if (idcine != that.idcine) return false;
        if (idsala != that.idsala) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idcine;
        result = 31 * result + idsala;
        return result;
    }
}
