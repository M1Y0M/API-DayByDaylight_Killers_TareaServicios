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

    public Optional<Killer> encontrarKiller(Long id) { //Optional para indicar que puede ser nulo.
        return killerRepo.findById(id);
    }

    public Killer crearKiller(Killer killer) {

        if (killerRepo.findByNombreOriginal(killer.getNombreOriginal())) {
            throw new RuntimeException("Ya existe un killer con ese " + killer.getNombreOriginal());
        } else {
            return killerRepo.save(killer); // Servicio envía el objeto a Repo (save), Repo guarda el objeto y se lo devuelve a servicio, Servicio devuelve el objeto guardado.
        }
    }

    public void borrarKiller(Long id) {
        killerRepo.deleteById(id);
    }

    public Optional<Killer> modificarKiller(Long id, Killer killerNuevosDatos) {

        //Busca el id y devuelve un opcional (null o no) --> el objeto.
        return killerRepo.findById(id).map(killerMod -> { //Función Lambda: si no es nulo se declara el objeto que se busca directamente y (->) pasa x.

            killerMod.setNombreKiller(killerNuevosDatos.getNombreKiller()); // Al objeto se le dan los datos que se han devuelto de la mod.
            killerMod.setNombreOriginal(killerNuevosDatos.getNombreOriginal());
            killerMod.setSitioOrigen(killerNuevosDatos.getSitioOrigen());
            killerMod.setEstatura(killerNuevosDatos.getEstatura());
            killerMod.setVelocidad(killerNuevosDatos.getVelocidad());
            killerMod.setRadioTerror(killerNuevosDatos.getRadioTerror());
            killerMod.setArma(killerNuevosDatos.getArma()); //Hacerla antes de. Se cambia el id en el put.
            killerMod.setHabilidad(killerNuevosDatos.getHabilidad());


            return killerRepo.save(killerMod); // Se vuelve a guardar el objeto.
        });

        //Resumen: Busca el objeto. Si lo encuentra map coge el objeto y le cambia directamente el nombre (lo declara y hace el .get() directamente).
        // Si no lo encuentra ignora .map y devuelve nulo (como un if).
    }

    public Optional<Killer> buscarPorNombreKillerYRadioTerror(String nombreKiller, int radioTerror) {
        return killerRepo.findByNombreKillerAndRadioTerror(nombreKiller, radioTerror);
    }

}
