package com.consultas.adapters.out.persistence;

import com.consultas.adapters.out.persistence.springdata.SpringDataAvaliacaoRepository;
import com.consultas.core.domain.Avaliacao;
import com.consultas.core.ports.out.AvaliacaoRepository;
import org.springframework.stereotype.Repository;

@Repository
public class AvaliacaoRepositoryAdapter implements AvaliacaoRepository {

    private final SpringDataAvaliacaoRepository jpaRepository;

    // Injeta o repositório do Spring Data
    public AvaliacaoRepositoryAdapter(SpringDataAvaliacaoRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public Avaliacao salvar(Avaliacao avaliacao) {
        return jpaRepository.save(avaliacao);
    }
}