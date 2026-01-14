package com.apiservicios.dbdkillers.controllers;

import com.apiservicios.dbdkillers.models.Arma;
import com.apiservicios.dbdkillers.services.ArmaServicio;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping ("/api/armas")
public class ArmaControlador {

    private ArmaServicio armaSer;

    public ArmaControlador (ArmaServicio armaSer) {
        this.armaSer = armaSer;
    }

    @GetMapping
    public List<Arma> todasLasArmas() {
        return armaSer.todasLasArmas();
    }

    @GetMapping("/{id}")
    public Optional<Arma> encontrarPorID(@PathVariable Long id) { //Optional para indicar que puede no existir.
            return armaSer.encontrarArma(id);
    }

    //Hacerlo antes que el Killer.
    @PostMapping // Endpoint para crear.
    public Arma crearArma(@RequestBody Arma arma) { // @RequestBody para que SB sepa que se trata de un objeto y pasarlo a java.
        return armaSer.crearArma(arma); // El controlador envía el objeto al servicio, servicio devuelve el objeto guardado y el controlador lo devuelve (en json).
    }

    @DeleteMapping("/{id}")
    public void borrarArmaPorID(@PathVariable Long id) {
        armaSer.borrarArma(id);
    }

    @PutMapping("/{id}")               //Para obtener el id que se ha buscado y el objeto.
    public Optional<Arma> modificarArma(@PathVariable Long id, @RequestBody Arma armaNuevosDatos) {
        return armaSer.modificarArma(id, armaNuevosDatos);
    }

    @PostMapping("/lote")
    public List<Arma> crearLoteArmas(@RequestBody List<Arma> armas) {
        return armaSer.saveAll(armas);
    }

/*
    @GetMapping("/{id}/conteo")
  //  public Long contar(PathVariable Long id) {
        return armaSer.conteo(id);
    }

 */
}
