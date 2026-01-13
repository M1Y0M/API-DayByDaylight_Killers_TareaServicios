package com.apiservicios.dbdkillers.controllers;

import com.apiservicios.dbdkillers.models.Killer;
import com.apiservicios.dbdkillers.services.KillerServicio;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/killers")
public class KillerControlador {

    private KillerServicio killerSer;

    public KillerControlador (KillerServicio killerSer) {
        this.killerSer = killerSer;
    }
    
    @GetMapping
    public List<Killer> todosLosKillers() {
        return killerSer.todosLosKillers();
    }

}
