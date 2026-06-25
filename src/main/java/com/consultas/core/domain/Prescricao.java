package com.consultas.core.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "prescricao")
public class Prescricao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idprescricao")
    private int idprescricao;

    @Column(name = "idprontuario", nullable = false)
    private int idprontuario;

    @ManyToOne
    @JoinColumn(name = "idmedicamento", nullable = false)
    private Medicamento medicamento;

    @Column(name = "dosagem", nullable = false, length = 45)
    private String dosagem;

    @Column(name = "administracao", nullable = false, length = 45)
    private String administracao;

    @Column(name = "tempo_de_uso", nullable = false, length = 45)
    private String tempoDeUso;

    protected Prescricao() {}

    public Prescricao(int idprescricao, int idprontuario, Medicamento medicamento,
                      String dosagem, String administracao, String tempoDeUso) {
        this.idprescricao = idprescricao;
        this.idprontuario = idprontuario;
        this.medicamento = medicamento;
        this.dosagem = dosagem;
        this.administracao = administracao;
        this.tempoDeUso = tempoDeUso;
    }

    public int getIdprescricao() { return idprescricao; }
    public int getIdprontuario() { return idprontuario; }
    public Medicamento getMedicamento() { return medicamento; }
    public String getDosagem() { return dosagem; }
    public String getAdministracao() { return administracao; }
    public String getTempoDeUso() { return tempoDeUso; }
}