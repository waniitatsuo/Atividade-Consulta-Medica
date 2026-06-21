package com.consultas.core.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Prontuario {
    private final int idprontuario;
    private final int idconsulta;
    private final double peso;
    private final double altura;
    private final String descricaoSintomas;
    private final String observacaoClinica;

    // Listas instanciadas internamente, protegidas do mundo exterior
    private final List<Exame> exames;
    private final List<Prescricao> prescricoes;

    public Prontuario(int idprontuario, int idconsulta, double peso, double altura, String descricaoSintomas, String observacaoClinica) {
        this.idprontuario = idprontuario;
        this.idconsulta = idconsulta;
        this.peso = peso;
        this.altura = altura;
        this.descricaoSintomas = descricaoSintomas;
        this.observacaoClinica = observacaoClinica;
        this.exames = new ArrayList<>();
        this.prescricoes = new ArrayList<>();
    }

    // --- MÉTODOS DE NEGÓCIO ---

    public void solicitarExame(Exame exame) {
        if (exame == null) {
            throw new IllegalArgumentException("O exame não pode ser nulo.");
        }
        this.exames.add(exame);
    }

    public void prescreverMedicamento(Prescricao prescricao) {
        if (prescricao == null) {
            throw new IllegalArgumentException("A prescrição não pode ser nula.");
        }
        this.prescricoes.add(prescricao);
    }

    // --- GETTERS ---

    public int getIdprontuario() { return idprontuario; }
    public int getIdconsulta() { return idconsulta; }
    public double getPeso() { return peso; }
    public double getAltura() { return altura; }
    public String getDescricaoSintomas() { return descricaoSintomas; }
    public String getObservacaoClinica() { return observacaoClinica; }

    // BLINDAGEM: Retorna uma versão "somente leitura" da lista
    public List<Exame> getExames() {
        return Collections.unmodifiableList(exames);
    }

    public List<Prescricao> getPrescricoes() {
        return Collections.unmodifiableList(prescricoes);
    }
}