package com.vaixapp.controller;

import com.vaixapp.model.Cliente;
import com.vaixapp.model.Contacto;
import com.vaixapp.repositorios.RepositorioClientes;
import com.vaixapp.repositorios.RepositorioContactos;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ControllerContactos {

    @GetMapping("contactos")
    public List<Contacto> listarClientes(){
        System.out.println("Alguien pidio un listado de contactos");
        return RepositorioContactos.listarTodosLosContactos();
    }

    @GetMapping("contactos/{idContacto}")
    public Contacto retornarCliente(@PathVariable final String idContacto){
        System.out.println("Alguien pidio datos del contacto " + idContacto);
        return RepositorioContactos.buscarContacto(Long.parseLong(idContacto));
    }

    @PostMapping("contactos")
    public Contacto crearNuevoCliente(@RequestBody Contacto contacto){
        System.out.println("Alguien está creando un nuevo contacto");
        RepositorioContactos.agregarContacto(contacto);
        return contacto;
    }

}
