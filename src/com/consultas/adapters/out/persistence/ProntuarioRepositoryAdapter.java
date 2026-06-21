package com.consultas.adapters.out.persistence;

import com.consultas.core.domain.Prontuario;
import com.consultas.core.ports.out.ProntuarioRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class ProntuarioRepositoryAdapter implements ProntuarioRepository {

    // Interface real do Spring Data JPA que vai fazer os INSERTs e SELECTs no banco
    private final SpringDataProntuarioRepository jpaRepository;

    public ProntuarioRepositoryAdapter(SpringDataProntuarioRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public Prontuario salvar(Prontuario prontuario) {
        // 1. Converte o objeto "Puro" do domínio para uma entidade do banco (com anotações @Entity, @Table, etc.)
        ProntuarioJpaEntity entity = new ProntuarioJpaEntity(prontuario);

        // 2. Salva no banco de dados
        ProntuarioJpaEntity salvo = jpaRepository.save(entity);

        // 3. Converte de volta para o domínio para não sujar as outras camadas
        return salvo.toDomain();
    }

    @Override
    public List<Prontuario> buscarHistoricoPorPaciente(int idpaciente) {
        // Lógica para buscar os dados via Spring Data e mapear para List<Prontuario>
        return jpaRepository.findByIdPaciente(idpaciente).stream()
                .map(ProntuarioJpaEntity::toDomain)
                .toList();
    }
}