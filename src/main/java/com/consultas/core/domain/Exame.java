package com.consultas.core.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "exame")
public class Exame {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idexame")
    private int idexame;

    @Column(name = "nome_exame", nullable = false, length = 100)
    private String nomeExame;

    protected Exame() {}

    public Exame(int idexame, String nomeExame) {
        this.idexame = idexame;
        this.nomeExame = nomeExame;
    }

    public int getIdexame() { return idexame; }
    public String getNomeExame() { return nomeExame; }
}