package com.javaweb.app01;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
// classe de controle
public class Controlador1 {

    @GetMapping("/")
    @ResponseBody
    public String home() {
        return "Primeiro Projeto Java Web com Spring Boot";
    }

    @GetMapping("/sobre")
    @ResponseBody
    public String sobre() {
        return "<h1>Sobre o projeto</h1>";
    }
}
