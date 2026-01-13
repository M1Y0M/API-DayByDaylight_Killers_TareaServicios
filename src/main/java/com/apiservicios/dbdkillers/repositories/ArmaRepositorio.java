package com.apiservicios.dbdkillers.repositories;

import com.apiservicios.dbdkillers.models.Arma;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArmaRepositorio extends JpaRepository <Arma, Long> {
}
