package com.consultas.core.ports.out;

import com.consultas.core.domain.Consulta;
import java.util.List;

public interface ConsultaRepository {
    List<Consulta> buscarConsultasPorData(int data);
    Consulta buscarPorId(int idconsulta);
    Consulta salvar(Consulta consulta);
}