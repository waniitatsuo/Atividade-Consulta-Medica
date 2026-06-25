package com.consultas.adapters.in.web;

public record ProntuarioRequestDTO(
        int idprontuario,
        int idconsulta,
        int idpaciente,
        double peso,
        double altura,
        String descricaoSintomas,
        String observacaoClinica
) {}