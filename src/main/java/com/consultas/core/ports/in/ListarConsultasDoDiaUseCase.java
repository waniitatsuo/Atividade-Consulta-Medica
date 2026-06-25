package com.consultas.core.ports.in;

import com.consultas.core.domain.Consulta;
import java.util.List;

public interface ListarConsultasDoDiaUseCase {
    List<Consulta> listar(int dataHoje);
}