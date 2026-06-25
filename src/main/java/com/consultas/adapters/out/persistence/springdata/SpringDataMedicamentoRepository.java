package com.consultas.adapters.out.persistence.springdata;

import com.consultas.core.domain.Medicamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataMedicamentoRepository extends JpaRepository<Medicamento, Integer> {
}