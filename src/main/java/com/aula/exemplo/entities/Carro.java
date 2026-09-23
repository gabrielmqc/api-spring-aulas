package com.aula.exemplo.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Carro {
    private int ano;
    private String modelo;
    private String cor;
    private String cheiro;
}
