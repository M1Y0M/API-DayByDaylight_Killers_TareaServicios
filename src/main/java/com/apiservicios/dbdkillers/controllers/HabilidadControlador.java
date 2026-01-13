package com.apiservicios.dbdkillers.controllers;

import com.apiservicios.dbdkillers.models.Habilidad;
import com.apiservicios.dbdkillers.services.HabilidadServicio;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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


}
