package com.consultas.adapters.out.persistence.springdata;
import com.consultas.core.domain.Avaliacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataAvaliacaoRepository extends JpaRepository<Avaliacao, Integer> {}