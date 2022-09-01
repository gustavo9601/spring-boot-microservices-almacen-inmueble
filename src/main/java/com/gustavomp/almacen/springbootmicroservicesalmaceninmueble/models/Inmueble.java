package com.gustavomp.almacen.springbootmicroservicesalmaceninmueble.models;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "inmuebles")
public class Inmueble {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // la BD se encargara de generar el ID
    private Long id;

    @Column(name = "nombre", length = 150, nullable = false)
    private String nombre;

    @Column(name = "descripcion", length = 500, nullable = false)
    private String direccion;

    @Column(name = "foto", length = 1500, nullable = true)
    private String foto;

    @Column(name = "precio", nullable = false)
    private Double precio;

    @Column(name = "fecha_creacion", nullable = false)
    private LocalDateTime fechaCreacion;

    @PrePersist
    public void prePersist() {
        this.setFechaCreacion(LocalDateTime.now());
    }

}
