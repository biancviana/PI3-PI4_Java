package com.lebi.model;

public class AgendaPaciente {
	private String especialidade;
	private String medico;
	private String nome;
	private String dia;
	private String horario;
	private Long id;
	
	
	public AgendaPaciente(String especialidade, String medico, String nome, String dia, String horario) {
		
		this.especialidade = especialidade;
		this.medico = medico;
		this.nome = nome;
		this.dia = dia;
		this.horario = horario;
	}
	
	public AgendaPaciente() {}
	
	public String getEspecialidade() {return especialidade;}
	public void setEspecialidade(String especialidade) {this.especialidade = especialidade;}
	
	public String getMedico() {return medico;}
	public void setMedico(String medico) {this.medico = medico;}
	
	public String getNome() {return nome;}
	public void setNome(String nome) {this.nome = nome;}
	
	public String getDia() {return dia;}
	public void setDia(String dia) {this.dia = dia;}
	
	public String getHorario() {return horario;}
	public void setHorario(String horario) {this.horario = horario;}

	public Long getId() {return id;}

	public void setId(Long id) {this.id = id;}
	
	
	
	
	
}
