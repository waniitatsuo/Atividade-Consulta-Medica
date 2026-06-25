package com.consultas.adapters.out.persistence;

import com.consultas.core.domain.PlanoSaude;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanoSaudeRepositoryAdapter extends JpaRepository<PlanoSaude, Integer> {
}