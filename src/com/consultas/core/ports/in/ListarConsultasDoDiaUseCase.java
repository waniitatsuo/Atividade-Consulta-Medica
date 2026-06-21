package com.consultas.core.ports.in;

import com.consultas.core.domain.Consulta;
import java.util.List;

public interface ListarConsultasDoDiaUseCase {
    // Retorna a lista de consultas agendadas para uma data específica
    List<Consulta> listar(int dataHoje);
}