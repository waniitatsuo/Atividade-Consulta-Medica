package com.consultas.core.ports.in;

import com.consultas.core.domain.Prontuario;

public interface RegistrarProntuarioUseCase {
    Prontuario registrar(Prontuario prontuario);
}