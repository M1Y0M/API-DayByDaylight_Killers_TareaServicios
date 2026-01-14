package com.apiservicios.dbdkillers.services;

import com.apiservicios.dbdkillers.models.Arma;
import com.apiservicios.dbdkillers.repositories.ArmaRepositorio;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArmaServicio {

    private ArmaRepositorio armaRepo;

    public ArmaServicio (ArmaRepositorio armaRepo) {
        this.armaRepo = armaRepo;
    }

    public List<Arma> todasLasArmas() {
        return armaRepo.findAll();
    }

    public Optional<Arma> encontrarArma(Long id) { //Optional para indicar que puede no existir.
        return armaRepo.findById(id);
    }

    public Arma crearArma(Arma arma) {
        return armaRepo.save(arma); // Servicio envía el objeto a Repo (save), Repo guarda el objeto y se lo devuelve a servicio, Servicio devuelve el objeto guardado.
    }



}
