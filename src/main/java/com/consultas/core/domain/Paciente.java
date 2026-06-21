package com.consultas.core.domain;

public class Paciente {
    private final int idpaciente;
    private final String nomeCrianca;
    private String nomeResponsavel;
    private final int dataNasc;
    private final String sexo;
    private Integer idplanoSaude; // Usamos o tipo Objeto (Integer) pois o vínculo com o plano é opcional (0..1) [cite: 23, 33]
    private int idendereco;

    // Construtor padrão para pacientes particulares (sem plano de saúde inicial) [cite: 33, 150]
    public Paciente(int idpaciente, String nomeCrianca, String nomeResponsavel, int dataNasc, String sexo, int idendereco) {
        this.idpaciente = idpaciente;
        this.nomeCrianca = nomeCrianca;
        this.nomeResponsavel = nomeResponsavel;
        this.dataNasc = dataNasc;
        this.sexo = sexo;
        this.idendereco = idendereco;
        this.idplanoSaude = null; // Define o estado inicial como atendimento particular
    }

    // --- MÉTODOS DE NEGÓCIO (Substituem os Setters) ---

    public void vincularPlanoSaude(int idplanoSaude) {
        if (idplanoSaude <= 0) {
            throw new IllegalArgumentException("O identificador do plano de saúde fornecido é inválido.");
        }
        this.idplanoSaude = idplanoSaude;
    }

    public void desvincularPlanoSaude() {
        this.idplanoSaude = null; // Transiciona o paciente de volta para a modalidade particular
    }

    public void atualizarResponsavel(String novoResponsavel) {
        if (novoResponsavel == null || novoResponsavel.trim().isEmpty()) {
            throw new IllegalArgumentException("O nome do responsável legal não pode estar em branco.");
        }
        this.nomeResponsavel = novoResponsavel;
    }

    public void mudarDeEndereco(int novoIdEndereco) {
        if (novoIdEndereco <= 0) {
            throw new IllegalArgumentException("O identificador do novo endereço é inválido.");
        }
        this.idendereco = novoIdEndereco;
    }

    // --- GETTERS (Permitem que as camadas externas de persistência e apresentação leiam o estado) ---

    public int getIdpaciente() {
        return idpaciente;
    }

    public String getNomeCrianca() {
        return nomeCrianca;
    }

    public String getNomeResponsavel() {
        return nomeResponsavel;
    }

    public int getDataNasc() {
        return dataNasc;
    }

    public String getSexo() {
        return sexo;
    }

    public Integer getIdplanoSaude() {
        return idplanoSaude;
    }

    public int getIdendereco() {
        return idendereco;
    }
}