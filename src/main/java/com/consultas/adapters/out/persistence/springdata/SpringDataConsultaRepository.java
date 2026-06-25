package com.consultas.adapters.out.persistence.springdata;

import com.consultas.core.domain.Consulta;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface SpringDataConsultaRepository extends JpaRepository<Consulta, Integer> {
    List<Consulta> findByDataHora(int dataHora);
}