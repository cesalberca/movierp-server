package com.movierp.server.entities;

import javax.persistence.*;

@Entity
@Table(name = "usuarios", schema = "movierp")
public class UsuariosEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_usuario", nullable = false)
    private long idUsuario;

    @Column(name = "rol")
    private String rol;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "contrasena")
    private String contrasena;

    @OneToOne
    @JoinColumn(name = "id_empleado")
    private EmpleadosEntity empleadosEntity;

    public UsuariosEntity() {
    }

    public UsuariosEntity(String rol, String nombre, String contrasena, EmpleadosEntity empleadosEntity) {
        this.rol = rol;
        this.nombre = nombre;
        this.contrasena = contrasena;
        this.empleadosEntity = empleadosEntity;
    }

    public long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public EmpleadosEntity getEmpleadosEntity() {
        return empleadosEntity;
    }

    public void setEmpleadosEntity(EmpleadosEntity empleadosEntity) {
        this.empleadosEntity = empleadosEntity;
    }
}
