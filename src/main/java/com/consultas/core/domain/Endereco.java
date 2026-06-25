package com.consultas.core.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "endereco")
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idendereco")
    private int idendereco;

    @Column(name = "logradouro", nullable = false, length = 45)
    private String logradouro;

    @Column(name = "numero", nullable = false, length = 45)
    private String numero;

    @Column(name = "complemento", length = 45)
    private String complemento;

    @Column(name = "bairro", nullable = false, length = 45)
    private String bairro;

    @Column(name = "cidade", nullable = false, length = 45)
    private String cidade;

    @Column(name = "estado", nullable = false, length = 45)
    private String estado;

    @Column(name = "cep", nullable = false, length = 11)
    private String cep;

    protected Endereco() {}

    public Endereco(int idendereco, String logradouro, String numero, String complemento,
                    String bairro, String cidade, String estado, String cep) {
        this.idendereco = idendereco;
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.cep = cep;
    }

    public int getIdendereco() { return idendereco; }
    public String getLogradouro() { return logradouro; }
    public String getNumero() { return numero; }
    public String getComplemento() { return complemento; }
    public String getBairro() { return bairro; }
    public String getCidade() { return cidade; }
    public String getEstado() { return estado; }
    public String getCep() { return cep; }
}