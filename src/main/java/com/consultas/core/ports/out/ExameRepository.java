package com.consultas.core.ports.out;

import com.consultas.core.domain.Exame;
import java.util.List;

public interface ExameRepository {
    List<Exame> listarTodos();
    Exame buscarPorId(int idexame);
}
