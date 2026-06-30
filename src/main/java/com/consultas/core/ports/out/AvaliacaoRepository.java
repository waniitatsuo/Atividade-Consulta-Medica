package com.consultas.core.ports.out;

import com.consultas.core.domain.Avaliacao;

public interface AvaliacaoRepository {
    Avaliacao salvar(Avaliacao avaliacao);
}