package com.aula.exemplo.controllers;

import com.aula.exemplo.entities.Pessoa;
import com.aula.exemplo.services.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pessoa")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @GetMapping
    public List<Pessoa> getCadastrados() {
        return pessoaService.getCadastrados();
    }

    @PostMapping
    public Pessoa addPessoa(@RequestBody Pessoa pessoa) {
        return pessoaService.addPessoa(pessoa);
    }

    @PutMapping("/{id}")
    public Pessoa updatePessoa(@PathVariable Long id, @RequestBody Pessoa pessoa) {
        return pessoaService.updatePessoa(id, pessoa);
    }

    @DeleteMapping("/{id}")
    public void deletePessoa(@PathVariable Long id) {
        pessoaService.deletePessoa(id);
    }
}
