package com.consultas.adapters.out.persistence;

import com.consultas.adapters.out.persistence.springdata.SpringDataPacienteRepository;
import com.consultas.core.domain.Paciente;
import com.consultas.core.ports.out.PacienteRepository;
import org.springframework.stereotype.Repository;

@Repository
public class PacienteRepositoryAdapter implements PacienteRepository {

    private final SpringDataPacienteRepository jpaRepository;

    public PacienteRepositoryAdapter(SpringDataPacienteRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public Paciente buscarPorId(int idpaciente) {
        return jpaRepository.findById(idpaciente).orElse(null);
    }

    @Override
    public Paciente salvar(Paciente paciente) {
        return jpaRepository.save(paciente);
    }
}