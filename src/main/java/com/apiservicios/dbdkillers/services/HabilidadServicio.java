package com.apiservicios.dbdkillers.services;

import com.apiservicios.dbdkillers.models.Habilidad;
import com.apiservicios.dbdkillers.repositories.HabilidadRepositorio;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HabilidadServicio {

    private HabilidadRepositorio habilidadRepo;

    public HabilidadServicio (HabilidadRepositorio habilidadRepo) {
        this.habilidadRepo = habilidadRepo;
    }

    public List<Habilidad> todasLasHabilidades() {
        return habilidadRepo.findAll();
    }

}
