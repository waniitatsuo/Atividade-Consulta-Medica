package com.consultas.core.domain;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Entity
@Table(name = "prontuario")
public class Prontuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idprontuario")
    private int idprontuario;

    @Column(name = "idconsulta", nullable = false)
    private int idconsulta;

    @Column(name = "idpaciente", nullable = false)
    private int idpaciente;

    @Column(name = "peso", nullable = false)
    private double peso;

    @Column(name = "altura", nullable = false)
    private double altura;

    @Column(name = "descricao_sintomas", columnDefinition = "TEXT")
    private String descricaoSintomas;

    @Column(name = "observacao_clinica", columnDefinition = "TEXT")
    private String observacaoClinica;

    @ManyToMany
    @JoinTable(
            name = "prontuario_exame",
            joinColumns = @JoinColumn(name = "idprontuario"),
            inverseJoinColumns = @JoinColumn(name = "idexame")
    )
    private List<Exame> exames = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "idprontuario")
    private List<Prescricao> prescricoes = new ArrayList<>();

    protected Prontuario() {}

    public Prontuario(int idprontuario, int idconsulta, int idpaciente, double peso,
                      double altura, String descricaoSintomas, String observacaoClinica) {
        this.idprontuario = idprontuario;
        this.idconsulta = idconsulta;
        this.idpaciente = idpaciente;
        this.peso = peso;
        this.altura = altura;
        this.descricaoSintomas = descricaoSintomas;
        this.observacaoClinica = observacaoClinica;
    }

    public void solicitarExame(Exame exame) {
        if (exame == null) throw new IllegalArgumentException("O exame não pode ser nulo.");
        this.exames.add(exame);
    }

    public void prescreverMedicamento(Prescricao prescricao) {
        if (prescricao == null) throw new IllegalArgumentException("A prescrição não pode ser nula.");
        this.prescricoes.add(prescricao);
    }

    public int getIdprontuario() { return idprontuario; }
    public int getIdconsulta() { return idconsulta; }
    public int getIdpaciente() { return idpaciente; }
    public double getPeso() { return peso; }
    public double getAltura() { return altura; }
    public String getDescricaoSintomas() { return descricaoSintomas; }
    public String getObservacaoClinica() { return observacaoClinica; }
    public List<Exame> getExames() { return Collections.unmodifiableList(exames); }
    public List<Prescricao> getPrescricoes() { return Collections.unmodifiableList(prescricoes); }
}