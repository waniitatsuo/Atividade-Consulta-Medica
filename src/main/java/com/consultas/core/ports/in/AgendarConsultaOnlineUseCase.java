package com.consultas.core.ports.in;

import com.consultas.core.domain.Consulta;

public interface AgendarConsultaOnlineUseCase {
    Consulta agendar(Consulta consulta, double valorConsulta);
}
