package com.apiservicios.dbdkillers.controllers;

import com.apiservicios.dbdkillers.models.Arma;
import com.apiservicios.dbdkillers.models.Killer;
import com.apiservicios.dbdkillers.services.KillerServicio;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/killers")
public class KillerControlador {

    private KillerServicio killerSer;

    public KillerControlador (KillerServicio killerSer) {
        this.killerSer = killerSer;
    }


    
    @GetMapping
    public List<Killer> todosLosKillers() {
        return killerSer.todosLosKillers();
    }

    @GetMapping("/{id}")                    // PathVariable para que coja el dato de la ruta.
    public Optional<Killer> encontrarPorID(@PathVariable Long id) { //Optional para indicar que puede no existir.
       return killerSer.encontrarKiller(id);
    }

    @PostMapping // Endpoint para crear.
    public Killer crearKiller(@RequestBody Killer killer) { // @RequestBody para que SB sepa que se trata de un objeto y pasarlo a java.
        return killerSer.crearKiller(killer); // El controlador envía el objeto al servicio, servicio devuelve el objeto guardado y el controlador lo devuelve (en json).
    }

    @DeleteMapping("/{id}")
    public void borrarKillerPorID(@PathVariable Long id) {
        killerSer.borrarKiller(id);
    }

    @PutMapping("/{id}")               //Para obtener el id que se ha buscado y el objeto.
    public Optional<Killer> modificarArma(@PathVariable Long id, @RequestBody Killer killerNuevosDatos) {
        return killerSer.modificarKiller(id, killerNuevosDatos);
    }

    @GetMapping("/buscar") // Se usan los datos en lugar del atributo.
    public Optional<Killer> encontrarPorNombreYRadio(@RequestParam String nombreKiller, @RequestParam int radioTerror) {
        return killerSer.buscarPorNombreKillerYRadioTerror(nombreKiller, radioTerror);
    }


}
