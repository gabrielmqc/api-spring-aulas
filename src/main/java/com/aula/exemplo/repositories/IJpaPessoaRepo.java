package com.aula.exemplo.repositories;

import com.aula.exemplo.entities.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IJpaPessoaRepo extends JpaRepository<Pessoa, Long> {
}
