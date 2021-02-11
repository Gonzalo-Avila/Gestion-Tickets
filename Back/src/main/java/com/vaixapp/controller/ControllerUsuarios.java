package com.vaixapp.controller;

import com.vaixapp.model.Cliente;
import com.vaixapp.model.Usuario;
import com.vaixapp.repositorios.RepositorioClientes;
import com.vaixapp.repositorios.RepositorioUsuarios;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ControllerUsuarios {

    @GetMapping("usuarios")
    public List<Usuario> listarUsuarios(){
        System.out.println("Alguien pidio un listado de usuarios");
        return RepositorioUsuarios.listarTodosLosUsuarios();
    }
}
