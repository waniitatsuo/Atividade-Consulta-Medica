package com.consultas.core.application;

import com.consultas.core.domain.Consulta;
import com.consultas.core.domain.Prontuario;
import com.consultas.core.ports.in.RegistrarProntuarioUseCase;
import com.consultas.core.ports.out.ConsultaRepository;
import com.consultas.core.ports.out.ProntuarioRepository;
import org.springframework.stereotype.Service;

@Service
public class RegistrarProntuarioService implements RegistrarProntuarioUseCase {

    private final ProntuarioRepository prontuarioRepository;
    private final ConsultaRepository consultaRepository;

    public RegistrarProntuarioService(ProntuarioRepository prontuarioRepository,
                                      ConsultaRepository consultaRepository) {
        this.prontuarioRepository = prontuarioRepository;
        this.consultaRepository = consultaRepository;
    }

    @Override
    public Prontuario registrar(Prontuario prontuario) {
        Consulta consulta = consultaRepository.buscarPorId(prontuario.getIdconsulta());
        if (consulta == null) {
            throw new IllegalArgumentException("Consulta não encontrada no sistema.");
        }
        consulta.gerarProntuario(prontuario);
        consultaRepository.salvar(consulta);
        return prontuarioRepository.salvar(prontuario);
    }
}