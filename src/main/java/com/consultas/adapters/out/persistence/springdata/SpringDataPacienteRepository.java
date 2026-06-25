package com.consultas.adapters.out.persistence.springdata;

import com.consultas.core.domain.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataPacienteRepository extends JpaRepository<Paciente, Integer> {
}