package com.movierp.server.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Table(name = "empleados")
public class Employee implements Serializable {
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
}
