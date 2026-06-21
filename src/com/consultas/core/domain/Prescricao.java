package com.consultas.core.domain;

public class Prescricao {
    private final int idprescricao;
    private final Medicamento medicamento;
    private final String dosagem;
    private final String administracao;
    private final String tempoDeUso;

    public Prescricao(int idprescricao, Medicamento medicamento, String dosagem, String administracao, String tempoDeUso) {
        this.medicamento = medicamento;
        this.idprescricao = idprescricao;
        this.dosagem = dosagem;
        this.administracao = administracao;
        this.tempoDeUso = tempoDeUso;
    }

    public int getIdprescricao() { return idprescricao; }
    public Medicamento getMedicamento() { return medicamento; }
    public String getDosagem() { return dosagem; }
    public String getAdministracao() { return administracao; }
    public String getTempoDeUso() { return tempoDeUso; }
}