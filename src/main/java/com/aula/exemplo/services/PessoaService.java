package com.aula.exemplo.services;

import com.aula.exemplo.entities.Pessoa;
import com.aula.exemplo.repositories.IJpaPessoaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PessoaService {

    @Autowired
    private IJpaPessoaRepo pessoaRepo;

    public List<Pessoa> getCadastrados() {
        return pessoaRepo.findAll();
    }

    public Pessoa addPessoa(Pessoa pessoa) {
        pessoaRepo.save(pessoa);
        return pessoa;
    }

    public Pessoa updatePessoa(Long id, Pessoa pessoa) {

        Optional<Pessoa> pessoaDoBanco = pessoaRepo.findById(id);
        if(pessoaDoBanco.isEmpty()){
            throw new IllegalArgumentException("Pessoa não encontrada");
        }
        pessoaDoBanco.get().setName(pessoa.getName());
        pessoaDoBanco.get().setCpf(pessoa.getCpf());
        pessoaDoBanco.get().setEmail(pessoa.getEmail());

        pessoaRepo.save(pessoaDoBanco.get());

        return pessoaDoBanco.get();
    }

    public void deletePessoa(Long id) {
        pessoaRepo.deleteById(id);
    }
}
