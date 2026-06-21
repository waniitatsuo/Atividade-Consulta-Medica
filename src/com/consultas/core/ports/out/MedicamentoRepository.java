package com.consultas.core.ports.out;

import com.consultas.core.domain.Medicamento;
import java.util.List;

public interface MedicamentoRepository {
    List<Medicamento> listarTodos();
    Medicamento buscarPorId(int idmedicamento);
}
