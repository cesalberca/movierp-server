package com.movierp.server.entities;

import javax.persistence.*;

/**
 * Created by Cesar
 */
@Entity
@Table(name = "USUARIOS", schema = "movierp", catalog = "")
public class UsuariosEntity {
    private int idusuario;
    private String rol;
    private String nombre;
    private String contrasena;
    private Integer idempleado;

    @Id
    @Column(name = "IDUSUARIO")
    public int getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
    }

    @Basic
    @Column(name = "ROL")
    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    @Basic
    @Column(name = "NOMBRE")
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Basic
    @Column(name = "CONTRASENA")
    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    @Basic
    @Column(name = "IDEMPLEADO")
    public Integer getIdempleado() {
        return idempleado;
    }

    public void setIdempleado(Integer idempleado) {
        this.idempleado = idempleado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UsuariosEntity that = (UsuariosEntity) o;

        if (idusuario != that.idusuario) return false;
        if (rol != null ? !rol.equals(that.rol) : that.rol != null) return false;
        if (nombre != null ? !nombre.equals(that.nombre) : that.nombre != null) return false;
        if (contrasena != null ? !contrasena.equals(that.contrasena) : that.contrasena != null) return false;
        if (idempleado != null ? !idempleado.equals(that.idempleado) : that.idempleado != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idusuario;
        result = 31 * result + (rol != null ? rol.hashCode() : 0);
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        result = 31 * result + (contrasena != null ? contrasena.hashCode() : 0);
        result = 31 * result + (idempleado != null ? idempleado.hashCode() : 0);
        return result;
    }
}
