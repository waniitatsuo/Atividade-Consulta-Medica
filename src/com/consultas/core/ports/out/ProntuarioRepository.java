package com.consultas.core.ports.out;

import com.consultas.core.domain.Prontuario;
import java.util.List;

public interface ProntuarioRepository {
    Prontuario salvar(Prontuario prontuario);
    List<Prontuario> buscarHistoricoPorPaciente(int idpaciente);
}