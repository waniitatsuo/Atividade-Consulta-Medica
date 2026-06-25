package com.consultas.core.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "consulta")
public class Consulta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idconsulta")
    private int idconsulta;

    @Column(name = "idpaciente", nullable = false)
    private int idpaciente;

    @Column(name = "idmedico", nullable = false)
    private int idmedico;

    @Column(name = "data_hora", nullable = false)
    private int dataHora;

    @Column(name = "novo_paciente", nullable = false)
    private boolean novoPaciente;

    @Column(name = "agendada", nullable = false)
    private boolean agendada;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "idprontuario")
    private Prontuario prontuario;

    protected Consulta() {}

    public Consulta(int idconsulta, int idpaciente, int idmedico, int dataHora, boolean novoPaciente) {
        this.idconsulta = idconsulta;
        this.idpaciente = idpaciente;
        this.idmedico = idmedico;
        this.dataHora = dataHora;
        this.novoPaciente = novoPaciente;
        this.agendada = true;
    }

    public void cancelarAgendamento() {
        if (!this.agendada) throw new IllegalStateException("A consulta já está cancelada.");
        this.agendada = false;
    }

    public void remarcar(int novaDataHora) {
        if (!this.agendada) throw new IllegalStateException("Não é possível remarcar uma consulta cancelada.");
        this.dataHora = novaDataHora;
    }

    public void gerarProntuario(Prontuario prontuario) {
        if (this.prontuario != null) throw new IllegalStateException("Esta consulta já possui um prontuário.");
        if (!this.agendada) throw new IllegalStateException("Não é possível gerar prontuário para consulta cancelada.");
        this.prontuario = prontuario;
    }

    public int getIdconsulta() { return idconsulta; }
    public int getIdpaciente() { return idpaciente; }
    public int getIdmedico() { return idmedico; }
    public int getDataHora() { return dataHora; }
    public boolean isNovoPaciente() { return novoPaciente; }
    public boolean isAgendada() { return agendada; }
    public Prontuario getProntuario() { return prontuario; }
}