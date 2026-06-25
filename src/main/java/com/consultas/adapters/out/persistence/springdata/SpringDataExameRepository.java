package com.consultas.adapters.out.persistence.springdata;

import com.consultas.core.domain.Exame;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataExameRepository extends JpaRepository<Exame, Integer> {
}