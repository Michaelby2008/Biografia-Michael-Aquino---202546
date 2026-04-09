package com.michaelaquino.primeraPaginaThy.controller;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class RegisterController {

    private final InMemoryUserDetailsManager userDetailsManager;
    private final PasswordEncoder passwordEncoder;

    public RegisterController(InMemoryUserDetailsManager userDetailsManager,PasswordEncoder passwordEncoder) {
        this.userDetailsManager = userDetailsManager;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/register")
    public String registerForm() {
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(
            @RequestParam String username,
            @RequestParam String password,
            Model model) {

        if (userDetailsManager.userExists(username)) {
            model.addAttribute("error", "El usuario ya existe");
            return "register";
        }

        userDetailsManager.createUser(
                User.withUsername(username)
                        .password(passwordEncoder.encode(password))
                        .roles("USER")
                        .build()
        );

        // Agregamos el mensaje de éxito y volvemos a la misma página
        model.addAttribute("success", "¡Cuenta creada con éxito! Ya puedes iniciar sesión.");
        return "register";
    }
}