# Movierp-server

API REST y capa de persistencia para Movierp.

# Stack de tecnologías

* Maven
* Spring Boot
* Spring Rest
* Spring JPA
* Tomcat

# Arquitectura

```
-com.movierp.server
    - entities
        Movie
    - services
        MovieService
    - controllers
        MovieController
```

# JPA

[JPA](https://docs.oracle.com/javaee/6/tutorial/doc/bnbpz.html) es la capa de persistencia de datos provista por Java. Esta capa provee de una API en forma de [anotaciones](https://docs.oracle.com/javase/tutorial/java/annotations/) que se incluyen en los [POJOS](https://en.wikipedia.org/wiki/Plain_Old_Java_Object) y en los repositorios.

Un repositorio es una clase que hace de DAO (Data Access Object), lo que quiere decir que ésta se encargará de hacer las peticiones a la base de datos y modelará esas peticiones sobre los objetos definidos (POJOs).

Las anotaciones son una forma de solucionar el problema de tener que gestionar un fichero xml enorme de configuración, además de poder incluir la configuración sobre un POJO. 

## Modelado

La forma de modelar las relaciones que usa JPA es mediante anotaciones. Estas anotaciones se hacen siempre sobre los POJOs. Un ejemplo de POJO es el siguiente:

```java
import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "cines", schema = "movierp")
// Implementa Serializable
public class CinesEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_cine", nullable = false)
    private long idCine;

    @Column(name = "cif")
    private String cif;

    @Column(name = "direccion")
    private String direccion;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "codigo_postal")
    private Integer codigoPostal;

    @OneToMany(mappedBy = "cinesEntity")
    private List<SalasEntity> salas;

    @OneToMany(mappedBy = "cinesEntity")
    private List<EmpleadosEntity> empleados;

    // Constructor vacío
    public CinesEntity() {
    }

    // Constructor por defecto. Nótese que el id no es necesario para construir un objeto, ya que éste se autogenera.
    public CinesEntity(String cif, String direccion, String nombre, Integer codigoPostal) {
        this.cif = cif;
        this.direccion = direccion;
        this.nombre = nombre;
        this.codigoPostal = codigoPostal;
    }

    // Getters y setters. Si un campo es inmutable (Aquel que no debe cambiar, como por ejemplo un id) no debe tener setter, solo getter. 
}
```

De este POJO que representa la tabla `cines` en nuestra base de datos se pueden observar varias anotaciones:

* `@Entity`: Esta anotación quiere decir que este objeto representa una entidad de nuestra base de datos.
* `@Table(name = "cines", schema = "movierp)`: Esta anotación sirve para mapear este POJO a una tabla en concreto. Si el nombre del POJO no coincide con el de la tabla de la base de datos se debe poner esta anotación. También mencionar que los POJOs por convención se ponen en singular mientras que las tablas de las bases de datos se ponen en plural.
    * `name = "cines"`: Nombre de la tabla que representa
    * `schema = "movierp"`: Nombre de la base de datos
* `@Id`: Anotación para representar un campo que es `primary key`. Por convención todos los POJOs deberían tener un Id propio.
* `@GeneratedValue`: Esta anotación quiere decir que el campo al que se refiere se autogenerará. Esta generación la dará la base de datos. Por ejemplo, si tenemos una serie de datos cuyo id va desde el 1 al 10, si se hace una nueva inserción el id nuevo tendrá como valor el 11.
    * `strategy = GenerationType.AUTO`: Hay varios tipos de estrategias para generar ids, el que se suele usar es este.
* `@Column(name = "id_cine")`: Mapea un campo a una columna. Se puede omitir si dicho campo tiene el mismo nombre que el campo de la base de datos.
* `@OneToMany`: Indica un tipo de relación entre tablas, se verá en el [siguiente apartado](#relaciones).

## Relaciones

Hasta ahora estamos modelando campos y atributos de un POJO, ¿pero qué hay de las relaciones? Las relaciones en cualquier base de datos relacional vienen dadas por tablas intermedias y el uso de claves foráneas y primarias. 

Como Java es orientado a objetos podemos hacer uso de ello _incrustando_ dentro de un POJO otro POJO o una colección (Array) de POJOs. Para que esto funcione correctamente además se debe hacer uso de las siguientes anotaciones:
 
* OneToOne
* OneToMany
* ManyToMany
* ManyToOne
 
Dentro de este tipo de anotaciones hay que distinguir si una relación es unidireccional o bidireccional. Para ello tenemos que __marcar__ quién es propietario de la relación. 
 
Por ejemplo, si tenemos una relación 1:1 en nuestra base de datos entre la tabla `facura_pedido` y la tabla `pedidos` (Lo que quiere decir que un cliente sólamente tendrá un pedido y un pedido sólamente puede ser tenido por un cliente) se traduciría de la siguiente forma:
 
```java
@Entity
@Table(name = "factura") 
public class Factura implements Serializable  {
    @Id 
    @Column(name = "id_factura", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idFactura;
    
    @Column(name = "id_pedido")
    private long idPedido;
    
    @Column(name = "cantidad")
    private double cantidad;
    
    @OneToOne
    @JoinColumn(name = "id_pedido") 
    private Order order;
    
    // Constructores, getters y setters
}
```
 
La anotación `@OneToOne` indica que es una relación 1:1 y la anotación `@JoinColumn` indica  quién es el que va a mapear la relación, es decir quién es la clave foránea dentro de un pojo.
 
```java
@Entity
@Table(name = "pedidos") 
public class Order implements Serializable {
    @Id 
    @Column(name = "id_pedido", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idPedido;
    
    @Column(name = "id_cliente")
    private long idCliente;
    
    // Entidad que es propietaria de la relación
    @OneToOne(mappedBy = "pedido")
    private Factura factura;       
    
    // Constructores, getters y setters
}
```
 
Veamos ahora un ejemplo de `@ManyToOne`. Queremos modelar la relación que existe entre un departamento y un empleado. La relación 1:N, ya que un empleado sólamente puede trabajar en un departamente y en un departamento pueden trabajar muchos empleados.
 
```java
@Entity
public class Empleado implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) 	
    private int idEmpleado;
    private String nombre;
    private double salario;
    
    @ManyToOne
    @JoinColumn(name = "id_departamento")
    private Departamento departamento;
    
    // Constructores, getters y setters
}
```

```java
@Entity
public class Departamento implements Serializable {
    @Id 
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String nombre;
 
    // Constructores, getters y setters
}
```

Hay que destacar que esta relación es unidireccional, ya que un Empleado pertenece a un departamento, pero en este caso el departamento no tien un listado de todos los empleados.