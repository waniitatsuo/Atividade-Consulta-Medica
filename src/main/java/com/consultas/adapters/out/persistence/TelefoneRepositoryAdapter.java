package com.consultas.adapters.out.persistence;

import com.consultas.core.domain.Telefone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface TelefoneRepositoryAdapter extends JpaRepository<Telefone, Integer> {
    List<Telefone> findByIdpaciente(int idpaciente);
}