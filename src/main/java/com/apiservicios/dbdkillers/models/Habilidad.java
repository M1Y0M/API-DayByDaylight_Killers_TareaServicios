package com.apiservicios.dbdkillers.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Habilidad {

    @Id
    @GeneratedValue
    private int id;
    private String nombre;
    private String descripcion;
    private double cooldown;

}
