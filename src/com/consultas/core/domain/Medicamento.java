package com.consultas.core.domain;

public class Medicamento {
    private final int idmedicamento;
    private final String nomeMedicamento;

    public Medicamento(int idmedicamento, String nomeMedicamento) {
        this.idmedicamento = idmedicamento;
        this.nomeMedicamento = nomeMedicamento;
    }

    public int getIdmedicamento() { return idmedicamento; }
    public String getNomeMedicamento() { return nomeMedicamento; }
}
