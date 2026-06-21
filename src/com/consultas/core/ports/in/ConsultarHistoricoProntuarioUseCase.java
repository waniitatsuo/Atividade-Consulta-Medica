package com.consultas.core.ports.in;

import com.consultas.core.domain.Prontuario;
import java.util.List;

public interface ConsultarHistoricoProntuarioUseCase {
    // Retorna todos os prontuários associados a um paciente
    List<Prontuario> consultarPorPaciente(int idpaciente);
}
