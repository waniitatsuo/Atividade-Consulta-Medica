package com.consultas.core.domain;

public class Consulta {
    private int idconsulta;
    private int idpaciente;
    private int idmedico;
    private int dataHora;
    private boolean novoPaciente;
    private boolean agendada;
    private Prontuario prontuario;

    public Consulta(int idconsulta, int idpaciente, int idmedico, int dataHora, boolean novoPaciente) {
        this.idconsulta = idconsulta;
        this.idpaciente = idpaciente;
        this.idmedico = idmedico;
        this.dataHora = dataHora;
        this.novoPaciente = novoPaciente;
        this.agendada = true; // Toda consulta nasce agendada por padrão
    }

    // --- MÉTODOS DE NEGÓCIO (Substituem os Setters) ---

    public void cancelarAgendamento() {
        if (!this.agendada) {
            throw new IllegalStateException("A consulta já está cancelada ou finalizada.");
        }
        this.agendada = false;
    }

    public void remarcar(int novaDataHora) {
        if (!this.agendada) {
            throw new IllegalStateException("Não é possível remarcar uma consulta cancelada.");
        }
        this.dataHora = novaDataHora;
    }

    public void gerarProntuario(Prontuario prontuario) {
        if (this.prontuario != null) {
            throw new IllegalStateException("Esta consulta já possui um prontuário vinculado.");
        }
        if (!this.agendada) {
            throw new IllegalStateException("Não é possível gerar prontuário para uma consulta cancelada.");
        }
        this.prontuario = prontuario;
    }

    // --- GETTERS (Para o mundo exterior poder ler o estado) ---

    public int getIdconsulta() { return idconsulta; }
    public int getIdpaciente() { return idpaciente; }
    public int getIdmedico() { return idmedico; }
    public int getDataHora() { return dataHora; }
    public boolean isNovoPaciente() { return novoPaciente; }
    public boolean isAgendada() { return agendada; }
    public Prontuario getProntuario() { return prontuario; }
}