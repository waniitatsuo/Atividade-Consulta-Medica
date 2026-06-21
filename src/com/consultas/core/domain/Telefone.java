package com.consultas.core.domain;

public class Telefone {
    private final int idpaciente;
    private final String numero;
    private final String tipo; // Ex: "Residencial", "Celular"

    public Telefone(int idpaciente, String numero, String tipo) {
        this.idpaciente = idpaciente;
        this.numero = numero;
        this.tipo = tipo;
    }

    public int getIdpaciente() { return idpaciente; }
    public String getNumero() { return numero; }
    public String getTipo() { return tipo; }
}