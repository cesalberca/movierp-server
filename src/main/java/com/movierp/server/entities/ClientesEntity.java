package com.movierp.server.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Table(name = "clientes", schema = "movierp")
public class ClientesEntity implements Serializable {
    @Id
    @GeneratedValue
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
}
