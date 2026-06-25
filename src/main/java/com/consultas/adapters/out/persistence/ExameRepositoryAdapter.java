package com.consultas.adapters.out.persistence;

import com.consultas.adapters.out.persistence.springdata.SpringDataExameRepository;
import com.consultas.core.domain.Exame;
import com.consultas.core.ports.out.ExameRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class ExameRepositoryAdapter implements ExameRepository {

    private final SpringDataExameRepository jpaRepository;

    public ExameRepositoryAdapter(SpringDataExameRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public List<Exame> listarTodos() {
        return jpaRepository.findAll();
    }

    @Override
    public Exame buscarPorId(int idexame) {
        return jpaRepository.findById(idexame).orElse(null);
    }
}