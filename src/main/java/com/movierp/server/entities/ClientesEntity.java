package com.movierp.server.entities;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by Cesar
 */
@Entity
@Table(name = "clientes", schema = "movierp", catalog = "")
public class ClientesEntity {
    private String apellidos;
    private String dni;
    private String email;
    private String nombre;
    private long idCliente;
    private Collection<VentasEntity> ventassByIdCliente;

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
    @Column(name = "email", nullable = true, length = 200)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "nombre", nullable = true, length = 100)
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Id
    @Column(name = "id_cliente", nullable = false)
    public long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(long idCliente) {
        this.idCliente = idCliente;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ClientesEntity that = (ClientesEntity) o;

        if (idCliente != that.idCliente) return false;
        if (apellidos != null ? !apellidos.equals(that.apellidos) : that.apellidos != null) return false;
        if (dni != null ? !dni.equals(that.dni) : that.dni != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (nombre != null ? !nombre.equals(that.nombre) : that.nombre != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = apellidos != null ? apellidos.hashCode() : 0;
        result = 31 * result + (dni != null ? dni.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        result = 31 * result + (int) (idCliente ^ (idCliente >>> 32));
        return result;
    }

    @OneToMany(mappedBy = "clientesByIdCliente")
    public Collection<VentasEntity> getVentassByIdCliente() {
        return ventassByIdCliente;
    }

    public void setVentassByIdCliente(Collection<VentasEntity> ventassByIdCliente) {
        this.ventassByIdCliente = ventassByIdCliente;
    }
}
