package com.consultas.adapters.out.persistence;

import com.consultas.core.domain.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoRepositoryAdapter extends JpaRepository<Endereco, Integer> {
}