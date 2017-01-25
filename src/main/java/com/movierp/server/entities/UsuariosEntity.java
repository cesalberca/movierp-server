package com.movierp.server.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "usuarios", schema = "movierp")
public class UsuariosEntity implements Serializable {
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

    @OneToOne
    @JoinColumn(name = "id_empleado")
    private EmpleadosEntity empleadosEntity;
}
