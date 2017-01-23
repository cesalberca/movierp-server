package com.movierp.server.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "cines", schema = "movierp", catalog = "")
public class CinesEntity {
    private String cif;
    private String direccion;
    private String nombre;
    private long idCine;
    private Integer codigoPostal;
    @JsonIgnore
    private Collection<EmpleadosEntity> empleadossByIdCine;
    @JsonIgnore
    private Collection<SalasEntity> salassByIdCine;

    @Basic
    @Column(name = "cif", nullable = true, length = 9)
    public String getCif() {
        return cif;
    }

    public void setCif(String cif) {
        this.cif = cif;
    }

    @Basic
    @Column(name = "direccion", nullable = true, length = 100)
    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Basic
    @Column(name = "nombre", nullable = true, length = 50)
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Id
    @Column(name = "id_cine", nullable = false)
    public long getIdCine() {
        return idCine;
    }

    public void setIdCine(long idCine) {
        this.idCine = idCine;
    }

    @Basic
    @Column(name = "codigo_postal", nullable = true)
    public Integer getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(Integer codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CinesEntity that = (CinesEntity) o;

        if (idCine != that.idCine) return false;
        if (cif != null ? !cif.equals(that.cif) : that.cif != null) return false;
        if (direccion != null ? !direccion.equals(that.direccion) : that.direccion != null) return false;
        if (nombre != null ? !nombre.equals(that.nombre) : that.nombre != null) return false;
        if (codigoPostal != null ? !codigoPostal.equals(that.codigoPostal) : that.codigoPostal != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = cif != null ? cif.hashCode() : 0;
        result = 31 * result + (direccion != null ? direccion.hashCode() : 0);
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        result = 31 * result + (int) (idCine ^ (idCine >>> 32));
        result = 31 * result + (codigoPostal != null ? codigoPostal.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "cinesByIdCine")
    public Collection<EmpleadosEntity> getEmpleadossByIdCine() {
        return empleadossByIdCine;
    }

    public void setEmpleadossByIdCine(Collection<EmpleadosEntity> empleadossByIdCine) {
        this.empleadossByIdCine = empleadossByIdCine;
    }

    @OneToMany(mappedBy = "cinesByIdCine")
    public Collection<SalasEntity> getSalassByIdCine() {
        return salassByIdCine;
    }

    public void setSalassByIdCine(Collection<SalasEntity> salassByIdCine) {
        this.salassByIdCine = salassByIdCine;
    }
}
