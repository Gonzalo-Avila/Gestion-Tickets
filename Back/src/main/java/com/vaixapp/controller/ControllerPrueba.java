package com.vaixapp.controller;

import com.vaixapp.model.Caso;
import com.vaixapp.model.enums.EstadoDeCaso;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@Controller
public class ControllerPrueba {
    @GetMapping
    public String homeForm(Model model) {
        System.out.println("Alguien pidio el home");
        model.addAttribute("valor",500);
        return "home.html";
    }
    @ResponseBody

    @GetMapping("caso")
    public Caso retornarCaso(){
        Caso caso = new Caso();
        caso.setDescripcion("Caso de prueba");
        caso.setEstado(EstadoDeCaso.PENDIENTE);
        caso.setResolucion("Esta abierto");
        caso.setFechaApertura(LocalDateTime.now());
        return caso;
    }
}
