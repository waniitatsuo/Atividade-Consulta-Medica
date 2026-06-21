package com.consultas.core.domain;

public class Medico {
    private final int idmedico;
    private final String nomeMedico;
    private final String crm;

    public Medico(int idmedico, String nomeMedico, String crm) {
        this.idmedico = idmedico;
        this.nomeMedico = nomeMedico;
        this.crm = crm;
    }

    // --- GETTERS (Sem nenhum setter, garantindo a imutabilidade) ---

    public int getIdmedico() {
        return idmedico;
    }

    public String getNomeMedico() {
        return nomeMedico;
    }

    public String getCrm() {
        return crm;
    }
}