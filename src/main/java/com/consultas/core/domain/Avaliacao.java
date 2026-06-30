package com.consultas.core.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "avaliacao")
public class Avaliacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idavaliacao")
    private int idavaliacao;

    @Column(name = "idconsulta", nullable = false)
    private int idconsulta;

    @Column(name = "nota", nullable = false)
    private int nota; // Esperado de 1 a 5

    @Column(name = "comentario", columnDefinition = "TEXT")
    private String comentario;

    protected Avaliacao() {}

    public Avaliacao(int idconsulta, int nota, String comentario) {
        if (nota < 1 || nota > 5) {
            throw new IllegalArgumentException("A nota de avaliação deve estar entre 1 e 5.");
        }
        this.idconsulta = idconsulta;
        this.nota = nota;
        this.comentario = comentario;
    }

    public int getIdavaliacao() { return idavaliacao; }
    public int getIdconsulta() { return idconsulta; }
    public int getNota() { return nota; }
    public String getComentario() { return comentario; }
}
