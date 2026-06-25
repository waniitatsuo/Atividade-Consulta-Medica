package com.consultas.core.ports.in;

import com.consultas.core.domain.Prontuario;
import java.util.List;

public interface ConsultarHistoricoProntuarioUseCase {
    List<Prontuario> consultarPorPaciente(int idpaciente);
}