package com.movierp.server.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "salas", schema = "movierp")
public class SalasEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_sala", nullable = false)
    private long idSala;

    @Column(name = "numero_butacas")
    private Integer numeroButacas;

    @ManyToOne
    @JoinColumn(name = "id_cine")
    private CinesEntity cinesEntity;

    @OneToMany(mappedBy = "salasEntity")
    private List<SesionesEntity> sesiones;

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

    public List<SesionesEntity> getSesiones() {
        return sesiones;
    }

    public void setSesiones(List<SesionesEntity> sesiones) {
        this.sesiones = sesiones;
    }
}
