package com.apiservicios.dbdkillers.repositories;

import com.apiservicios.dbdkillers.models.Killer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KillerRespositorio extends JpaRepository <Killer, Long> {

}
