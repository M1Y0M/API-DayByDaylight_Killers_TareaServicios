package com.apiservicios.dbdkillers.services;

import com.apiservicios.dbdkillers.models.Arma;
import com.apiservicios.dbdkillers.models.Habilidad;
import com.apiservicios.dbdkillers.repositories.HabilidadRepositorio;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
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

    public Optional<Habilidad> encontrarHabilidad(Long id) { //Optional para indicar que puede ser nulo.
        return habilidadRepo.findById(id);
    }

    public Habilidad crearHabilidad(Habilidad habilidad) {
        return habilidadRepo.save(habilidad); // Servicio envía el objeto a Repo (save), Repo guarda el objeto y se lo devuelve a servicio, Servicio devuelve el objeto guardado.
    }

    public void borrarHabilidad(Long id) {
        habilidadRepo.deleteById(id);
    }

    public Optional<Habilidad> modificarHabilidad(Long id, Habilidad habilidadNuevosDatos) {

        //Busca el id y devuelve un opcional (null o no) --> el objeto.
        return habilidadRepo.findById(id).map(habilidadMod -> { //Función Lambda: si no es nulo se declara el objeto que se busca directamente y (->) pasa x.

            habilidadMod.setNombre(habilidadNuevosDatos.getNombre()); // Al objeto se le dan los datos que se han devuelto de la mod.
            habilidadMod.setDescripcion(habilidadNuevosDatos.getDescripcion());
            habilidadMod.setCooldown(habilidadNuevosDatos.getCooldown());

            return habilidadRepo.save(habilidadMod); // Se vuelve a guardar el objeto.
        });

        //Resumen: Busca el objeto. Si lo encuentra map coge el objeto y le cambia directamente el nombre (lo declara y hace el .get() directamente).
        // Si no lo encuentra ignora .map y devuelve nulo (como un if).
    }

    /*
    public Map<String, Habilidad> patchUpdate(Long id, )
     */

    @Transactional
    public Habilidad patchUpdate(Long id, Habilidad habilidadModificada) {

        Habilidad habilidadUpdated = habilidadRepo.findById(id).get();

            if (!habilidadModificada.getNombre().isEmpty() && !habilidadModificada.getNombre().equals(habilidadUpdated.getNombre())) {
                habilidadUpdated.setNombre(habilidadModificada.getNombre()); // Al objeto se le dan los datos que se han devuelto de la mod.
            }

            if (!habilidadModificada.getDescripcion().isEmpty()  && !habilidadModificada.getDescripcion().equals(habilidadUpdated.getDescripcion())) {
                habilidadUpdated.setDescripcion(habilidadModificada.getDescripcion());
            }

            if (habilidadModificada.getCooldown() != habilidadUpdated.getCooldown()) {
                habilidadUpdated.setCooldown(habilidadModificada.getCooldown());
            }

            return habilidadRepo.save(habilidadUpdated);
        }

}



