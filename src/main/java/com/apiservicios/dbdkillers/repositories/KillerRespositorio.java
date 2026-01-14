package com.apiservicios.dbdkillers.repositories;

import com.apiservicios.dbdkillers.models.Killer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface KillerRespositorio extends JpaRepository <Killer, Long> {

    public Optional<Killer> findByNombreKillerAndRadioTerror(String nombreKiller, int radioTerror);

    //Hay que usar existBy cuando quieres q devuelva un booleano.
    public boolean existsByNombreOriginal(String nombreOriginal);

}
