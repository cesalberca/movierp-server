package com.movierp.server.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
@Table(name = "clientes", schema = "movierp")
public class ClientesEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_cliente", nullable = false)
    private long idCliente;

    @Column(name = "apellidos")
    private String apellidos;

    @Column(name = "dni")
    private String dni;

    @Column(name = "email")
    private String email;

    @Column(name = "nombre")
    private String nombre;

    @OneToMany(mappedBy = "clientesEntity")
    private Collection<VentasEntity> ventasEntities;

    public ClientesEntity() {
    }

    public ClientesEntity(String apellidos, String dni, String email, String nombre, Collection<VentasEntity> ventasEntities) {
        this.apellidos = apellidos;
        this.dni = dni;
        this.email = email;
        this.nombre = nombre;
        this.ventasEntities = ventasEntities;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(long idCliente) {
        this.idCliente = idCliente;
    }

    public Collection<VentasEntity> getVentasEntities() {
        return ventasEntities;
    }

    public void setVentassByIdCliente(Collection<VentasEntity> ventasEntities) {
        this.ventasEntities = ventasEntities;
    }

    public void setVentasEntities(Collection<VentasEntity> ventasEntities) {
        this.ventasEntities = ventasEntities;
    }
}
