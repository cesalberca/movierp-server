package com.movierp.server.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by Cesar
 */
@Entity
@Table(name = "empleados", schema = "movierp", catalog = "")
public class EmpleadosEntity {
    private long idEmpleado;
    private String nombre;
    private String apellidos;
    private String dni;
    private Long idCine;
    @JsonIgnore
    private CinesEntity cinesByIdCine;
    @JsonIgnore
    private Collection<UsuariosEntity> usuariossByIdEmpleado;

    @Id
    @Column(name = "id_empleado", nullable = false)
    public long getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(long idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    @Basic
    @Column(name = "nombre", nullable = true, length = 100)
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Basic
    @Column(name = "apellidos", nullable = true, length = 100)
    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    @Basic
    @Column(name = "dni", nullable = true, length = 9)
    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    @Basic
    @Column(name = "id_cine", nullable = true)
    public Long getIdCine() {
        return idCine;
    }

    public void setIdCine(Long idCine) {
        this.idCine = idCine;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EmpleadosEntity that = (EmpleadosEntity) o;

        if (idEmpleado != that.idEmpleado) return false;
        if (nombre != null ? !nombre.equals(that.nombre) : that.nombre != null) return false;
        if (apellidos != null ? !apellidos.equals(that.apellidos) : that.apellidos != null) return false;
        if (dni != null ? !dni.equals(that.dni) : that.dni != null) return false;
        if (idCine != null ? !idCine.equals(that.idCine) : that.idCine != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (idEmpleado ^ (idEmpleado >>> 32));
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        result = 31 * result + (apellidos != null ? apellidos.hashCode() : 0);
        result = 31 * result + (dni != null ? dni.hashCode() : 0);
        result = 31 * result + (idCine != null ? idCine.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "id_cine", referencedColumnName = "id_cine", insertable = false, updatable = false)
    public CinesEntity getCinesByIdCine() {
        return cinesByIdCine;
    }

    public void setCinesByIdCine(CinesEntity cinesByIdCine) {
        this.cinesByIdCine = cinesByIdCine;
    }

    @OneToMany(mappedBy = "empleadosByIdEmpleado")
    public Collection<UsuariosEntity> getUsuariossByIdEmpleado() {
        return usuariossByIdEmpleado;
    }

    public void setUsuariossByIdEmpleado(Collection<UsuariosEntity> usuariossByIdEmpleado) {
        this.usuariossByIdEmpleado = usuariossByIdEmpleado;
    }
}
