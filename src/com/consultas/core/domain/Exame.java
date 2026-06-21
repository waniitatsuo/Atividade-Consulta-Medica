package com.consultas.core.domain;

public class Exame {
    private final int idexame;
    private final String nomeExame;

    public Exame(int idexame, String nomeExame) {
        this.idexame = idexame;
        this.nomeExame = nomeExame;
    }

    public int getIdexame() { return idexame; }
    public String getNomeExame() { return nomeExame; }
}
