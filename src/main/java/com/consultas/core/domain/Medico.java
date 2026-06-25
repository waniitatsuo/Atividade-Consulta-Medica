package com.consultas.core.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "medico")
public class Medico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idmedico")
    private int idmedico;

    @Column(name = "nome_medico", nullable = false, length = 45)
    private String nomeMedico;

    @Column(name = "crm", nullable = false, unique = true, length = 20)
    private String crm;

    protected Medico() {}

    public Medico(int idmedico, String nomeMedico, String crm) {
        this.idmedico = idmedico;
        this.nomeMedico = nomeMedico;
        this.crm = crm;
    }

    public int getIdmedico() { return idmedico; }
    public String getNomeMedico() { return nomeMedico; }
    public String getCrm() { return crm; }
}