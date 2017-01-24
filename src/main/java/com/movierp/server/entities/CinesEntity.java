package com.movierp.server.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "cines", schema = "movierp")
public class CinesEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_cine", nullable = false)
    private long idCine;

    @Column(name = "cif")
    private String cif;

    @Column(name = "direccion")
    private String direccion;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "codigo_postal")
    private Integer codigoPostal;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cinesEntity")
    private List<EmpleadosEntity> empleadosEntities;

    public CinesEntity() {
    }

    public CinesEntity(String cif, String direccion, String nombre, Integer codigoPostal, List<EmpleadosEntity> empleadosEntities) {
        this.cif = cif;
        this.direccion = direccion;
        this.nombre = nombre;
        this.codigoPostal = codigoPostal;
        this.empleadosEntities = empleadosEntities;
    }

    public String getCif() {
        return cif;
    }

    public void setCif(String cif) {
        this.cif = cif;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public long getIdCine() {
        return idCine;
    }

    public void setIdCine(long idCine) {
        this.idCine = idCine;
    }

    public Integer getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(Integer codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public List<EmpleadosEntity> getEmpleadosEntities() {
        return empleadosEntities;
    }

    public void setEmpleadosEntities(List<EmpleadosEntity> empleadosEntities) {
        this.empleadosEntities = empleadosEntities;
    }
}
