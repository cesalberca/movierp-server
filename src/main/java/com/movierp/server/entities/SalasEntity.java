package com.movierp.server.entities;

import javax.persistence.*;

@Entity
@Table(name = "salas", schema = "movierp")
public class SalasEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_sala", nullable = false)
    private long idSala;

    @Column(name = "numero_butacas")
    private Integer numeroButacas;

    @ManyToOne
    @JoinColumn(name = "id_cine")
    private CinesEntity cinesEntity;

    public SalasEntity() {
    }

    public SalasEntity(Integer numeroButacas, CinesEntity cinesEntity) {
        this.numeroButacas = numeroButacas;
        this.cinesEntity = cinesEntity;
    }

    public long getIdSala() {
        return idSala;
    }

    public void setIdSala(long idSala) {
        this.idSala = idSala;
    }

    public Integer getNumeroButacas() {
        return numeroButacas;
    }

    public void setNumeroButacas(Integer numeroButacas) {
        this.numeroButacas = numeroButacas;
    }

    public CinesEntity getCinesEntity() {
        return cinesEntity;
    }

    public void setCinesEntity(CinesEntity cinesEntity) {
        this.cinesEntity = cinesEntity;
    }
}
