package com.apiservicios.dbdkillers.services;

import com.apiservicios.dbdkillers.models.Arma;
import com.apiservicios.dbdkillers.repositories.ArmaRepositorio;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArmaServicio {

    private ArmaRepositorio armaRepo;

    public ArmaServicio (ArmaRepositorio armaRepo) {
        this.armaRepo = armaRepo;
    }

    public List<Arma> todasLasArmas() {
        return armaRepo.findAll();
    }

}
