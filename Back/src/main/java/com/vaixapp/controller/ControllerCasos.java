package com.vaixapp.controller;

import com.vaixapp.model.Caso;
import com.vaixapp.repositorios.RepositorioCasos;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ControllerCasos {
    @GetMapping("casos")
    public List<Caso> listarCasos(){
        System.out.println("Alguien pidio un listado de casos");
        return RepositorioCasos.listarTodosLosCasos();
    }

    @PostMapping("casos")
    public Caso crearNuevoCaso(@RequestBody Caso caso){
        System.out.println("Alguien está creando un nuevo caso");
        RepositorioCasos.agregarCaso(caso);
        return caso;
    }

    @GetMapping("casos/{idCaso}")
    public Caso obtenerCaso(@PathVariable final String idCaso){
        System.out.println("Alguien pidio el caso " + idCaso);
        return RepositorioCasos.buscarCaso(Long.parseLong(idCaso));
    }

    @PutMapping("casos/{idCaso}")
    public void actualizarCaso(@PathVariable final String idCaso, @RequestBody Caso caso){
        System.out.println("Se está actualizando el caso: " + caso.getId());
        RepositorioCasos.actualizarCaso(caso);
    }
}

