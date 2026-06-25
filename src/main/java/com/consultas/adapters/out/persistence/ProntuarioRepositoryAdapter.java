package com.consultas.adapters.out.persistence;

import com.consultas.adapters.out.persistence.springdata.SpringDataProntuarioRepository;
import com.consultas.core.domain.Prontuario;
import com.consultas.core.ports.out.ProntuarioRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class ProntuarioRepositoryAdapter implements ProntuarioRepository {

    private final SpringDataProntuarioRepository jpaRepository;

    public ProntuarioRepositoryAdapter(SpringDataProntuarioRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public Prontuario salvar(Prontuario prontuario) {
        return jpaRepository.save(prontuario);
    }

    @Override
    public List<Prontuario> buscarHistoricoPorPaciente(int idpaciente) {
        return jpaRepository.findByIdpaciente(idpaciente);
    }
}