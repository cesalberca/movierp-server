package com.movierp.server.entities;

import javax.persistence.*;

/**
 * Created by Cesar
 */
@Entity
@Table(name = "usuarios", schema = "movierp", catalog = "")
public class UsuariosEntity {
    private long idUsuario;
    private String rol;
    private String nombre;
    private String contrasena;
    private Long idEmpleado;
    private EmpleadosEntity empleadosByIdEmpleado;

    @Id
    @Column(name = "id_usuario", nullable = false)
    public long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(long idUsuario) {
        this.idUsuario = idUsuario;
    }

    @Basic
    @Column(name = "rol", nullable = true, length = 50)
    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    @Basic
    @Column(name = "nombre", nullable = true, length = 50)
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Basic
    @Column(name = "contrasena", nullable = true, length = 50)
    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    @Basic
    @Column(name = "id_empleado", nullable = true)
    public Long getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(Long idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UsuariosEntity that = (UsuariosEntity) o;

        if (idUsuario != that.idUsuario) return false;
        if (rol != null ? !rol.equals(that.rol) : that.rol != null) return false;
        if (nombre != null ? !nombre.equals(that.nombre) : that.nombre != null) return false;
        if (contrasena != null ? !contrasena.equals(that.contrasena) : that.contrasena != null) return false;
        if (idEmpleado != null ? !idEmpleado.equals(that.idEmpleado) : that.idEmpleado != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (idUsuario ^ (idUsuario >>> 32));
        result = 31 * result + (rol != null ? rol.hashCode() : 0);
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        result = 31 * result + (contrasena != null ? contrasena.hashCode() : 0);
        result = 31 * result + (idEmpleado != null ? idEmpleado.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "id_empleado", referencedColumnName = "id_empleado", insertable = false, updatable = false)
    public EmpleadosEntity getEmpleadosByIdEmpleado() {
        return empleadosByIdEmpleado;
    }

    public void setEmpleadosByIdEmpleado(EmpleadosEntity empleadosByIdEmpleado) {
        this.empleadosByIdEmpleado = empleadosByIdEmpleado;
    }
}
