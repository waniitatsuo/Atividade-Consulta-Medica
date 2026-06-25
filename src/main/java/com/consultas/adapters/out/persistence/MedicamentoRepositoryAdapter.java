package com.consultas.adapters.out.persistence;

import com.consultas.adapters.out.persistence.springdata.SpringDataMedicamentoRepository;
import com.consultas.core.domain.Medicamento;
import com.consultas.core.ports.out.MedicamentoRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class MedicamentoRepositoryAdapter implements MedicamentoRepository {

    private final SpringDataMedicamentoRepository jpaRepository;

    public MedicamentoRepositoryAdapter(SpringDataMedicamentoRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public List<Medicamento> listarTodos() {
        return jpaRepository.findAll();
    }

    @Override
    public Medicamento buscarPorId(int idmedicamento) {
        return jpaRepository.findById(idmedicamento).orElse(null);
    }
}