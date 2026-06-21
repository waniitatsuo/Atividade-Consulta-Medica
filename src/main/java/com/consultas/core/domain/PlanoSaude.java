package com.consultas.core.domain;

public class PlanoSaude {
    private final int idplanoSaude;
    private final String nomePlano;

    public PlanoSaude(int idplanoSaude, String nomePlano) {
        this.idplanoSaude = idplanoSaude;
        this.nomePlano = nomePlano;
    }

    public int getIdplanoSaude() { return idplanoSaude; }
    public String getNomePlano() { return nomePlano; }
}