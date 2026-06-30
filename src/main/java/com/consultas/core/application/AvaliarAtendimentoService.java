package com.consultas.core.application;

import com.consultas.core.domain.Avaliacao;
import com.consultas.core.domain.Consulta;
import com.consultas.core.ports.in.AvaliarAtendimentoUseCase;
import com.consultas.core.ports.out.AvaliacaoRepository;
import com.consultas.core.ports.out.ConsultaRepository;
import org.springframework.stereotype.Service;

@Service
public class AvaliarAtendimentoService implements AvaliarAtendimentoUseCase {

    private final AvaliacaoRepository avaliacaoRepository;
    private final ConsultaRepository consultaRepository;

    public AvaliarAtendimentoService(AvaliacaoRepository avaliacaoRepository, ConsultaRepository consultaRepository) {
        this.avaliacaoRepository = avaliacaoRepository;
        this.consultaRepository = consultaRepository;
    }

    @Override
    public Avaliacao avaliar(int idconsulta, int nota, String comentario) {
        Consulta consulta = consultaRepository.buscarPorId(idconsulta);
        if (consulta == null) {
            throw new IllegalArgumentException("Consulta não encontrada.");
        }

        Avaliacao avaliacao = new Avaliacao(idconsulta, nota, comentario);
        return avaliacaoRepository.salvar(avaliacao);
    }
}