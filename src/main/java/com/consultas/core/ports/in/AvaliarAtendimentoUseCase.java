package com.consultas.core.ports.in;
import com.consultas.core.domain.Avaliacao;

public interface AvaliarAtendimentoUseCase {
    Avaliacao avaliar(int idconsulta, int nota, String comentario);
}