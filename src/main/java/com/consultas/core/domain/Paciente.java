package com.consultas.core.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "paciente")
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idpaciente")
    private int idpaciente;

    @Column(name = "nome_crianca", nullable = false, length = 45)
    private String nomeCrianca;

    @Column(name = "nome_responsavel", nullable = false, length = 45)
    private String nomeResponsavel;

    @Column(name = "data_nasc", nullable = false)
    private int dataNasc;

    @Column(name = "sexo", nullable = false, length = 10)
    private String sexo;

    @Column(name = "idplano_saude")
    private Integer idplanoSaude;

    @Column(name = "idendereco", nullable = false)
    private int idendereco;

    protected Paciente() {}

    public Paciente(int idpaciente, String nomeCrianca, String nomeResponsavel,
                    int dataNasc, String sexo, int idendereco) {
        this.idpaciente = idpaciente;
        this.nomeCrianca = nomeCrianca;
        this.nomeResponsavel = nomeResponsavel;
        this.dataNasc = dataNasc;
        this.sexo = sexo;
        this.idendereco = idendereco;
        this.idplanoSaude = null;
    }

    public void vincularPlanoSaude(int idplanoSaude) {
        if (idplanoSaude <= 0) throw new IllegalArgumentException("Identificador do plano inválido.");
        this.idplanoSaude = idplanoSaude;
    }

    public void desvincularPlanoSaude() { this.idplanoSaude = null; }

    public void atualizarResponsavel(String novoResponsavel) {
        if (novoResponsavel == null || novoResponsavel.trim().isEmpty())
            throw new IllegalArgumentException("Nome do responsável não pode estar em branco.");
        this.nomeResponsavel = novoResponsavel;
    }

    public void mudarDeEndereco(int novoIdEndereco) {
        if (novoIdEndereco <= 0) throw new IllegalArgumentException("Identificador de endereço inválido.");
        this.idendereco = novoIdEndereco;
    }

    public int getIdpaciente() { return idpaciente; }
    public String getNomeCrianca() { return nomeCrianca; }
    public String getNomeResponsavel() { return nomeResponsavel; }
    public int getDataNasc() { return dataNasc; }
    public String getSexo() { return sexo; }
    public Integer getIdplanoSaude() { return idplanoSaude; }
    public int getIdendereco() { return idendereco; }
}