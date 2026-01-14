package com.apiservicios.dbdkillers.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data // Crea los getters, setters, etc.
@NoArgsConstructor // Para que cree el constructor vacío.
public class Killer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Para indicar a SB que la DB va a generar los ids sola (para evitar un error al poner el id en la prueba pq así sql lee que ya existe ese id y suma para el siguiente)
    private Long id; // Long porque puede ser nulo y SB genera uno nuevo (int empieza con 0 y puede confundir eso como id).
    private String nombreKiller;
    private String nombreOriginal;
    private String sitioOrigen;
    private String estatura;
    private double velocidad;
    private int radioTerror;
    
    @OneToOne // Solo puede tener una habilidad.
    @JoinColumn (name = "habilidad") //El nombre por defecto sería habilidad_id (creo).
    private Habilidad habilidad;

    @ManyToOne
    @JoinColumn (name = "arma")
    Arma armas;

}
