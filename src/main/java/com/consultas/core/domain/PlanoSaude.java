package com.consultas.core.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "plano_saude")
public class PlanoSaude {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idplano_saude")
    private int idplanoSaude;

    @Column(name = "nome_plano", nullable = false, length = 100)
    private String nomePlano;

    protected PlanoSaude() {}

    public PlanoSaude(int idplanoSaude, String nomePlano) {
        this.idplanoSaude = idplanoSaude;
        this.nomePlano = nomePlano;
    }

    public int getIdplanoSaude() { return idplanoSaude; }
    public String getNomePlano() { return nomePlano; }
}