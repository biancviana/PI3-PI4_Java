package com.project.lebiton.model.impl;

public class Consulta {
    private String especialidade;
    private String medico;
    private String emailPaciente;
    private String emailMedico;
    private String dia;
    private String horario;
    private Long id;

    public Consulta(final String especialidade, final String medico, final String dia, final String emailPaciente, final String emailMedico, final String horario) {

        this.especialidade = especialidade;
        this.medico = medico;
        this.emailPaciente = emailPaciente;
        this.emailMedico = emailMedico;
        this.dia = dia;
        this.horario = horario;
    }

    public Consulta(final String medico, final String dia, final String emailPaciente, final String horario) {

        this.medico = medico;
        this.emailPaciente = emailPaciente;
        this.dia = dia;
        this.horario = horario;
    }

    public Consulta() {
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

    public String getEmailPaciente() {
        return emailPaciente;
    }

    public void setEmailPaciente(final String email) {
        this.emailPaciente = emailPaciente;
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

    public String getEmailMedico() {
        return emailMedico;
    }

    public void setEmailMedico(String emailMedico) {
        this.emailMedico = emailMedico;
    }

}
