package com.apiservicios.dbdkillers.controllers;

import com.apiservicios.dbdkillers.models.Arma;
import com.apiservicios.dbdkillers.models.Killer;
import com.apiservicios.dbdkillers.services.ArmaServicio;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping ("/api/armas")
public class ArmaControlador {

    private ArmaServicio armaSer;

    public ArmaControlador (ArmaServicio armaSer) {
        this.armaSer = armaSer;
    }

    @GetMapping
    public List<Arma> todasLasArmas() {
        return armaSer.todasLasArmas();
    }

}
