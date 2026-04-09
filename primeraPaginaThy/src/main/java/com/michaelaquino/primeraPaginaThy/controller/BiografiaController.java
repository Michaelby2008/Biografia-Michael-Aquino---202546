package com.michaelaquino.primeraPaginaThy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;
import java.util.List;

@Controller
public class BiografiaController {

    @GetMapping("/biografia")
    public String mostrarUsuario(Model model) {

        model.addAttribute("nombre", "Michael Yohardi Aquino Argueta");
        model.addAttribute("fechaNacimiento", "02/09/2008");
        model.addAttribute("unPocoDeMi", "Soy estudiante de Informatica enfocado en manejo de base de datos y diseño web y me gustan los gatos y jugar bastante con amigos.");
        model.addAttribute("nacionalidad","Guatemala");

        List<String> lista = Arrays.asList("Basquetbol", "Futbol", "Gimnasio", "Videojuegos");
        model.addAttribute("pasatiempos", lista);

        return "biografia";
    }
}