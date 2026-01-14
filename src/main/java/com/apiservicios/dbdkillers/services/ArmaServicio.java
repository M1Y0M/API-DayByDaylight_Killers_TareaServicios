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

    public Optional<Arma> encontrarArma(Long id) { //Optional para indicar que puede ser nulo.
        return armaRepo.findById(id);
    }

    public Arma crearArma(Arma arma) {
        return armaRepo.save(arma); // Servicio envía el objeto a Repo (save), Repo guarda el objeto y se lo devuelve a servicio, Servicio devuelve el objeto guardado.
    }

    public void borrarArma(Long id) {
        armaRepo.deleteById(id);
    }

    public Optional<Arma> modificarArma(Long id, Arma armaNuevosDatos) {
        //Busca el id y devuelve un opcional (null o no) --> el objeto.
        return armaRepo.findById(id).map(armaModificada -> { //Función Lambda: si no es nulo se declara el objeto que se busca directamente y (->) pasa x.
            armaModificada.setNombre(armaNuevosDatos.getNombre()); // Al objeto se le dan los datos que se han devuelto de la mod.
            return armaRepo.save(armaModificada); // Se vuelve a guardar el objeto.
        });
    //Resumen: Busca el objeto. Si lo encuentra map coge el objeto y le cambia directamente el nombre (lo declara y hace el .get() directamente).
    } // Si no lo encuentra ignora .map y devuelve nulo (como un if).

}
