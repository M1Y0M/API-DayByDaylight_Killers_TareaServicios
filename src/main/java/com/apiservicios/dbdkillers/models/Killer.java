package com.apiservicios.dbdkillers.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data // Crea los getters, setters, etc.
@NoArgsConstructor // Para que cree el constructor vacío.
@Table (name = "killer")
public class Killer {

    @Id
    @GeneratedValue // Mirar porque no sé si esto funciona al hacer una fila.
    private int id;
    private String nombreKiller;
    private String nombreOriginal;
    private String sitioOrigen;
    private int estatura;
    private double velocidad;
    private int radioTerror;
    
    @OneToOne // Solo puede tener una habilidad.
    @JoinColumn (name = "habilidad")
    private Habilidad habilidad;

    @OneToOne // Solo puede tener un arma.
    @JoinColumn (name = "arma")
    private Arma arma;

}
