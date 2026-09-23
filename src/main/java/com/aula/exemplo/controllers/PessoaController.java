package com.aula.exemplo.controllers;

import com.aula.exemplo.entities.Pessoa;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/pessoas")
public class PessoaController {

    private final List<Pessoa> pessoas = new ArrayList<>();

    @GetMapping
    public List<Pessoa> getPessoas() {
        return pessoas;
    }

    @PostMapping
    public Pessoa salvarPessoa(@RequestBody Pessoa pessoa) {
        pessoas.add(pessoa);
        return pessoa;
    }

    @GetMapping("/{nome}")
    public Pessoa getPessoa(@PathVariable String nome) {
        for (Pessoa pessoa : pessoas) {
            if (pessoa.getNome().equals(nome)) {
                return pessoa;
            }
        }
        return null;
    }

    @PutMapping("/{cpf}")
    public Pessoa updatePessoa(@PathVariable String cpf, @RequestBody Pessoa pessoa) {
        for (Pessoa pessoa1 : pessoas) {
            if (pessoa1.getCpf().equals(cpf)) {
                pessoa1.setNome(pessoa.getNome());
                pessoa1.setCpf(cpf);
                pessoa1.setIdade(pessoa.getIdade());
                pessoa1.setSexo(pessoa.getSexo());
                pessoa1.setEmail(pessoa.getEmail());
                return pessoa1;
            }
        }
        return null;
    }

    @DeleteMapping("/{cpf}")
    public void deletePessoa(@PathVariable String cpf) {
        for (Pessoa pessoa1 : pessoas) {
            if (pessoa1.getCpf().equals(cpf)) {
                pessoas.remove(pessoa1);
            }
        }
    }
}
