package com.lebi.model;

public class AgendaMedico {

	private String especialidade;
	private String nome;
	private String dia;
	private String horario;
	
		
	public AgendaMedico(String especialidade, String nome, String dia, String horario) {
		super();
		this.especialidade = especialidade;
		this.nome = nome;
		this.dia = dia;
		this.horario = horario;
	}
	
	public AgendaMedico() {}

	public String getEspecialidade() {return especialidade;}
	public void setEspecialidade(String especialidade) {this.especialidade = especialidade;}

	public String getNome() {return nome;}
	public void setNome(String nome) {this.nome = nome;}

	public String getDia() {return dia;}
	public void setDia(String dia) {this.dia = dia;}

	public String getHorario() {return horario;}
	public void setHorario(String horario) {this.horario = horario;}
	
	
}
