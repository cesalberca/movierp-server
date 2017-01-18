package com.movierp.server.entities;

import javax.persistence.*;

/**
 * Created by Cesar
 */
@Entity
@Table(name = "CINES", schema = "movierp")
public class CinesEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "IDCINE")
    private int idcine;

    @Column(name = "NOMBRE")
    public String nombre;

    @Column(name = "CIF")
    public String cif;

    @Column(name = "DIRECCION")
    public String direccion;

    @Column(name = "C_POSTAL")
    public Integer cPostal;

    CinesEntity() {

    }

    public CinesEntity(String nombre, String cif, String direccion, Integer cPostal) {
        this.nombre = nombre;
        this.cif = cif;
        this.direccion = direccion;
        this.cPostal = cPostal;
    }

    //@Id
    //@Column(name = "IDCINE")
    public int getIdcine() {
        return idcine;
    }

    public void setIdcine(int idcine) {
        this.idcine = idcine;
    }

    //@Basic
    //@Column(name = "NOMBRE")
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    //@Basic
    //@Column(name = "CIF")
    public String getCif() {
        return cif;
    }

    public void setCif(String cif) {
        this.cif = cif;
    }

    //@Basic
    //@Column(name = "DIRECCION")
    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    //@Basic
    //@Column(name = "C_POSTAL")
    public Integer getcPostal() {
        return cPostal;
    }

    public void setcPostal(Integer cPostal) {
        this.cPostal = cPostal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CinesEntity that = (CinesEntity) o;

        if (idcine != that.idcine) return false;
        if (nombre != null ? !nombre.equals(that.nombre) : that.nombre != null) return false;
        if (cif != null ? !cif.equals(that.cif) : that.cif != null) return false;
        if (direccion != null ? !direccion.equals(that.direccion) : that.direccion != null) return false;
        if (cPostal != null ? !cPostal.equals(that.cPostal) : that.cPostal != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idcine;
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        result = 31 * result + (cif != null ? cif.hashCode() : 0);
        result = 31 * result + (direccion != null ? direccion.hashCode() : 0);
        result = 31 * result + (cPostal != null ? cPostal.hashCode() : 0);
        return result;
    }
}
