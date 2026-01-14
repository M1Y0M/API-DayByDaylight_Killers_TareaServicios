package com.apiservicios.dbdkillers.services;

import com.apiservicios.dbdkillers.models.Arma;
import com.apiservicios.dbdkillers.models.Killer;
import com.apiservicios.dbdkillers.repositories.KillerRespositorio;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class KillerServicio {

    private KillerRespositorio killerRepo;

    public KillerServicio (KillerRespositorio killerRepo) { //Inyección del repositorio (Springboot lo detecta por la anotación y se lo pasa al constr.).
        this.killerRepo = killerRepo;
    }

    public List<Killer> todosLosKillers() {
        return killerRepo.findAll(); //No hace falta crear la lista, SB la devuelve solo.
    }

    public Optional<Killer> encontrarKiller(Long id) { //Optional para indicar que puede no existir.
        return killerRepo.findById(id);
    }

    public Killer crearKiller(Killer killer) {
        return killerRepo.save(killer); // Servicio envía el objeto a Repo (save), Repo guarda el objeto y se lo devuelve a servicio, Servicio devuelve el objeto guardado.
    }

}
