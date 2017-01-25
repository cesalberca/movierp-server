package com.movierp.server.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
@Table(name = "salas", schema = "movierp")
public class SalasEntity implements Serializable {
    @Id
    @GeneratedValue
    @Column(name = "id_sala", nullable = false)
    private long idSala;

    @Column(name = "numero_butacas")
    private Integer numeroButacas;

    @ManyToOne
    @JoinColumn(name = "id_cine")
    private CinesEntity cinesEntity;

    @OneToMany(mappedBy = "salasEntity")
    private List<SesionesEntity> sesiones;
}
