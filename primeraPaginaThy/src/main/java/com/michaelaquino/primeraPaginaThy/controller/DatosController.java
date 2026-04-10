package com.michaelaquino.primeraPaginaThy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DatosController {

    @GetMapping("/datos")
    public String mostrarDatos(Model model) {

        model.addAttribute("Nombre", "Michael Aquino");
        model.addAttribute("Apellido", "Aquino");
        model.addAttribute("Edad", 17);

        return "datos";
    }
}