package com.consultas.adapters.out.persistence;

import com.consultas.adapters.out.persistence.springdata.SpringDataConsultaRepository;
import com.consultas.core.domain.Consulta;
import com.consultas.core.ports.out.ConsultaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class ConsultaRepositoryAdapter implements ConsultaRepository {

    private final SpringDataConsultaRepository jpaRepository;

    public ConsultaRepositoryAdapter(SpringDataConsultaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public List<Consulta> buscarConsultasPorData(int data) {
        return jpaRepository.findByDataHora(data);
    }

    @Override
    public Consulta buscarPorId(int idconsulta) {
        return jpaRepository.findById(idconsulta).orElse(null);
    }

    @Override
    public Consulta salvar(Consulta consulta) {
        return jpaRepository.save(consulta);
    }
}