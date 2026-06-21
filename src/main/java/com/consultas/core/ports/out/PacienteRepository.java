package com.consultas.core.ports.out;

import com.consultas.core.domain.Paciente;

public interface PacienteRepository {
    Paciente buscarPorId(int idpaciente);
    Paciente salvar(Paciente paciente);
}