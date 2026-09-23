package com.aula.exemplo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/exemplo")
public class ExampleController {

    @GetMapping
    public String helloWorld(){
        return "Olá Mundo";
    }
}
