package com.vaixapp.controller;

import com.vaixapp.model.Caso;
import com.vaixapp.model.Cliente;
import com.vaixapp.repositorios.RepositorioCasos;
import com.vaixapp.repositorios.RepositorioClientes;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ControllerClientes {
    @GetMapping("clientes")
    public List<Cliente> listarClientes(){
        System.out.println("Alguien pidio un listado de clientes");
        return RepositorioClientes.listarTodosLosClientes();
    }

    @GetMapping("clientes/{idCliente}")
    public Cliente retornarCliente(@PathVariable final String idCliente){
        System.out.println("Alguien pidio datos del cliente " + idCliente);
        return RepositorioClientes.buscarCliente(Long.parseLong(idCliente));
    }

    @PostMapping("clientes")
    public Cliente crearNuevoCliente(@RequestBody Cliente cliente){
        System.out.println("Alguien está creando un nuevo cliente");
        RepositorioClientes.agregarCliente(cliente);
        return cliente;
    }

}
