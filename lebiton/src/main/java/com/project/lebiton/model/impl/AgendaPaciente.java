package com.project.lebiton.model.impl;

public class AgendaPaciente {
    private String especialidade;
    private String medico;
    private String email;
    private String dia;
    private String horario;
    private Long id;

    public AgendaPaciente(final String especialidade, final String medico, final String dia, final String email, final String horario) {

        this.especialidade = especialidade;
        this.medico = medico;
        this.email = email;
        this.dia = dia;
        this.horario = horario;
    }

    public AgendaPaciente() {
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(final String especialidade) {
        this.especialidade = especialidade;
    }

    public String getMedico() {
        return medico;
    }

    public void setMedico(final String medico) {
        this.medico = medico;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(final String dia) {
        this.dia = dia;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(final String horario) {
        this.horario = horario;
    }

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

}
