package com.consultas.adapters.out.persistence.springdata;

import com.consultas.core.domain.Prontuario;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface SpringDataProntuarioRepository extends JpaRepository<Prontuario, Integer> {
    List<Prontuario> findByIdpaciente(int idpaciente);
}