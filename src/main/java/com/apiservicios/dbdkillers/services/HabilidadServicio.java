package com.apiservicios.dbdkillers.services;

import com.apiservicios.dbdkillers.models.Arma;
import com.apiservicios.dbdkillers.models.Habilidad;
import com.apiservicios.dbdkillers.repositories.HabilidadRepositorio;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HabilidadServicio {

    private HabilidadRepositorio habilidadRepo;

    public HabilidadServicio (HabilidadRepositorio habilidadRepo) {
        this.habilidadRepo = habilidadRepo;
    }

    public List<Habilidad> todasLasHabilidades() {
        return habilidadRepo.findAll();
    }

    public Optional<Habilidad> encontrarHabilidad(Long id) { //Optional para indicar que puede no existir.
        return habilidadRepo.findById(id);
    }

    public Habilidad crearHabilidad(Habilidad habilidad) {
        return habilidadRepo.save(habilidad); // Servicio envía el objeto a Repo (save), Repo guarda el objeto y se lo devuelve a servicio, Servicio devuelve el objeto guardado.
    }

}
