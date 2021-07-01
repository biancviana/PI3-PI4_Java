package com.lebi.model;

import java.util.Date;

public class Agenda {
	private Long id;
	private String horario;
	private String dia;	
	
	public Agenda(Long id, String horario, String dia) {
		this.id = id;
		this.horario = horario;
		this.dia = dia;
	}
	
	public Agenda() {}
	
	public Long getId() {return id;}
	public void setId(Long id) {this.id = id;}
	
	public String getHorario() {return horario;}
	public void setHorario(String horario) {this.horario = horario;}
	
	public String getDia() {return dia;}
	public void setDia(String dia) {this.dia = dia;}
}
