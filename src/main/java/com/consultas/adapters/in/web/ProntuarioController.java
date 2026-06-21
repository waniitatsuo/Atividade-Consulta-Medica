package com.consultas.adapters.in.web;

import com.consultas.core.domain.Prontuario;
import com.consultas.core.ports.in.RegistrarProntuarioUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/prontuarios")
public class ProntuarioController {

    private final RegistrarProntuarioUseCase registrarProntuarioUseCase;

    public ProntuarioController(RegistrarProntuarioUseCase registrarProntuarioUseCase) {
        this.registrarProntuarioUseCase = registrarProntuarioUseCase;
    }

    @PostMapping
    public ResponseEntity<Prontuario> registrar(@RequestBody ProntuarioRequestDTO dto) {
        // Converte o DTO (JSON recebido) para o objeto de Domínio
        Prontuario prontuario = new Prontuario(
                dto.idprontuario(),
                dto.idconsulta(),
                dto.peso(),
                dto.altura(),
                dto.descricaoSintomas(),
                dto.observacaoClinica()
        );

        // O Controller não tem regra de negócio, ele apenas delega para o UseCase
        Prontuario registrado = registrarProntuarioUseCase.registrar(prontuario);

        return ResponseEntity.ok(registrado);
    }
}