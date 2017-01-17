package com.movierp.server.entities;

import javax.persistence.*;

/**
 * Created by Cesar
 */
@Entity
@Table(name = "CINES_SALAS", schema = "movierp", catalog = "")
@IdClass(CinesSalasEntityPK.class)
public class CinesSalasEntity {
    private int idcine;
    private int idsala;

    @Id
    @Column(name = "IDCINE")
    public int getIdcine() {
        return idcine;
    }

    public void setIdcine(int idcine) {
        this.idcine = idcine;
    }

    @Id
    @Column(name = "IDSALA")
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

        CinesSalasEntity that = (CinesSalasEntity) o;

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
