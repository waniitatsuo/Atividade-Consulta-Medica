package com.consultas.core.application;

import com.consultas.core.domain.Consulta;
import com.consultas.core.domain.Prontuario;
import com.consultas.core.ports.in.RegistrarProntuarioUseCase;
import com.consultas.core.ports.out.ConsultaRepository;
import com.consultas.core.ports.out.ProntuarioRepository;

public class RegistrarProntuarioService implements RegistrarProntuarioUseCase {

    // Injeção das Portas de Saída
    private final ProntuarioRepository prontuarioRepository;
    private final ConsultaRepository consultaRepository;

    public RegistrarProntuarioService(ProntuarioRepository prontuarioRepository, ConsultaRepository consultaRepository) {
        this.prontuarioRepository = prontuarioRepository;
        this.consultaRepository = consultaRepository;
    }

    @Override
    public Prontuario registrar(Prontuario prontuario) {
        // 1. Busca a consulta no banco de dados através da porta
        Consulta consulta = consultaRepository.buscarPorId(prontuario.getIdconsulta());
        if (consulta == null) {
            throw new IllegalArgumentException("Consulta não encontrada no sistema.");
        }

        // 2. Aplica a regra de negócio puramente no domínio
        // (Isso garante que uma consulta só receba um prontuário e esteja agendada)
        consulta.gerarProntuario(prontuario);

        // 3. Salva as alterações usando as portas de saída
        consultaRepository.salvar(consulta);
        return prontuarioRepository.salvar(prontuario);
    }
}