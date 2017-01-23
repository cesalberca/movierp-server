package com.movierp.server.entities;

import javax.persistence.*;

@Entity
@Table(name = "empleados", schema = "movierp")
public class EmpleadosEntity {

    @Id
    @Column(name = "id_empleado", nullable = false)
    private long idEmpleado;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellidos")
    private String apellidos;

    @Column(name = "dni")
    private String dni;

    @ManyToOne
    @JoinColumn(name = "id_cine")
    private CinesEntity cinesEntity;

    @OneToOne
    private UsuariosEntity usuariosEntity;

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

    public CinesEntity getCinesEntity() {
        return cinesEntity;
    }

    public void setCinesEntity(CinesEntity cinesEntity) {
        this.cinesEntity = cinesEntity;
    }

    public UsuariosEntity getUsuariosEntity() {
        return usuariosEntity;
    }

    public void setUsuariosEntity(UsuariosEntity usuariosEntity) {
        this.usuariosEntity = usuariosEntity;
    }
}
