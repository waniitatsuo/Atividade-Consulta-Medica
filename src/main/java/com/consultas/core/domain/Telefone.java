package com.consultas.core.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "telefone")
public class Telefone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idtelefone")
    private int idtelefone;

    @Column(name = "numero", nullable = false, length = 20)
    private String numero;

    @Column(name = "tipo", nullable = false, length = 15)
    private String tipo;

    @Column(name = "idpaciente", nullable = false)
    private int idpaciente;

    protected Telefone() {}

    public Telefone(int idtelefone, String numero, String tipo, int idpaciente) {
        this.idtelefone = idtelefone;
        this.numero = numero;
        this.tipo = tipo;
        this.idpaciente = idpaciente;
    }

    public int getIdtelefone() { return idtelefone; }
    public String getNumero() { return numero; }
    public String getTipo() { return tipo; }
    public int getIdpaciente() { return idpaciente; }
}