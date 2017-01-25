package com.movierp.server.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Table(name = "usuarios")
public class User implements Serializable {
    @Id
    @GeneratedValue
    @Column(name = "id_usuario", nullable = false)
    private long idUsuario;

    @Column(name = "rol")
    private String rol;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "contrasena")
    private String contrasena;

//    @OneToOne
//    @JoinColumn(name = "id_empleado")
//    private Employee employee;
}
