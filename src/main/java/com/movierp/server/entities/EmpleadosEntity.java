package com.movierp.server.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "empleados", schema = "movierp")
public class EmpleadosEntity implements Serializable {
    @Id
    @GeneratedValue
    @Column(name = "id_empleado", nullable = false)
    private long idEmpleado;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellidos")
    private String apellidos;

    @Column(name = "dni")
    private String dni;

    @Column(name = "id_cine")
    private long idCine;


    public EmpleadosEntity() {
    }

    public EmpleadosEntity(String nombre, String apellidos, String dni, long idCine) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni;
        this.idCine = idCine;
    }

    public long getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(long idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public long getIdCine() {
        return idCine;
    }

    public void setIdCine(long idCine) {
        this.idCine = idCine;
    }
}
