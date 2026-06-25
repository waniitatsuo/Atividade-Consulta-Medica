package com.consultas.core.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "medicamento")
public class Medicamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idmedicamento")
    private int idmedicamento;

    @Column(name = "nome_medicamento", nullable = false, length = 45)
    private String nomeMedicamento;

    protected Medicamento() {}

    public Medicamento(int idmedicamento, String nomeMedicamento) {
        this.idmedicamento = idmedicamento;
        this.nomeMedicamento = nomeMedicamento;
    }

    public int getIdmedicamento() { return idmedicamento; }
    public String getNomeMedicamento() { return nomeMedicamento; }
}