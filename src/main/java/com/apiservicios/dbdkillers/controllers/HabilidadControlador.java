package com.apiservicios.dbdkillers.controllers;

import com.apiservicios.dbdkillers.models.Arma;
import com.apiservicios.dbdkillers.models.Habilidad;
import com.apiservicios.dbdkillers.models.Killer;
import com.apiservicios.dbdkillers.services.HabilidadServicio;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/habilidades")
public class HabilidadControlador {

    private HabilidadServicio habilidadSer;

    public HabilidadControlador (HabilidadServicio habilidadSer) {
        this.habilidadSer = habilidadSer;
    }

    @GetMapping
    public List<Habilidad> todasLasHabilidades() {
        return habilidadSer.todasLasHabilidades();
    }

    @GetMapping("/{id}")
    public Optional<Habilidad> encontrarPorID(@PathVariable Long id) { //Optional para indicar que puede no existir.
        return habilidadSer.encontrarHabilidad(id);
    }

    //Hacerlo antes que el killer.
    @PostMapping // Endpoint para crear.
    public Habilidad crearHabilidad(@RequestBody Habilidad habilidad) { // @RequestBody para que SB sepa que se trata de un objeto y pasarlo a java.
        return habilidadSer.crearHabilidad(habilidad); // El controlador envía el objeto al servicio, servicio devuelve el objeto guardado y el controlador lo devuelve (en json).
    }


}
