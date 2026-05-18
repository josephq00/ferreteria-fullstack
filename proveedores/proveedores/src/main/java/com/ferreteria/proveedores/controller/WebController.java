package com.ferreteria.proveedores.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebController {

    @GetMapping("/")
    public String home(){
        return "Microservicio SUPPLIER funcionando 🚚";
    }
}