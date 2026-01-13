package com.apiservicios.dbdkillers.services;

import com.apiservicios.dbdkillers.models.Killer;
import com.apiservicios.dbdkillers.repositories.KillerRespositorio;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KillerServicio {

    private KillerRespositorio killerRepo;

    public KillerServicio (KillerRespositorio killerRepo) { //Inyección del repositorio (Springboot lo detecta por la anotación y se lo pasa al constr.).
        this.killerRepo = killerRepo;
    }

    public List<Killer> todosLosKillers() {
        return killerRepo.findAll(); //No hace falta crear la lista, SB la devuelve solo.
    }

}
