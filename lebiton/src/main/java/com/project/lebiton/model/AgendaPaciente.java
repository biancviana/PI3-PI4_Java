package com.project.lebiton.model;

public class AgendaPaciente {
    private String especialidade;
    private String medico;
    private String email;
    private String dia;
    private String horario;
    private Long id;

    public AgendaPaciente(String especialidade, String medico, String dia, String email, String horario) {

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

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public String getMedico() {
        return medico;
    }

    public void setMedico(String medico) {
        this.medico = medico;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
