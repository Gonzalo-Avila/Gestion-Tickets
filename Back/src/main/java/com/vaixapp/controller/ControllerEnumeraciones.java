package com.vaixapp.controller;

import com.vaixapp.model.Cliente;
import com.vaixapp.model.enums.CategoriaCaso;
import com.vaixapp.model.enums.EstadoDeCaso;
import com.vaixapp.model.enums.PrioridadCaso;
import com.vaixapp.model.enums.TipoUsuario;
import com.vaixapp.repositorios.RepositorioClientes;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ControllerEnumeraciones {

    @GetMapping("prioridades")
    public List<PrioridadCaso> listarPrioridadesDisponibles(){
        System.out.println("Alguien pidio un listado de prioridades disponibles");
        return Arrays.stream(PrioridadCaso.values()).collect(Collectors.toList());
    }

    @GetMapping("categorias")
    public List<CategoriaCaso> listarCategoriasDisponibles(){
        System.out.println("Alguien pidio un listado de categorias disponibles");
        return Arrays.stream(CategoriaCaso.values()).collect(Collectors.toList());
    }

    @GetMapping("estados")
    public List<EstadoDeCaso> listarEstadosDisponibles(){
        System.out.println("Alguien pidio un listado de estados disponibles");
        return Arrays.stream(EstadoDeCaso.values()).collect(Collectors.toList());
    }

    @GetMapping("tiposusuario")
    public List<TipoUsuario> listarTiposDeUsuarioDisponibles(){
        System.out.println("Alguien pidio un listado de tipos de usuario disponibles");
        return Arrays.stream(TipoUsuario.values()).collect(Collectors.toList());
    }

}
