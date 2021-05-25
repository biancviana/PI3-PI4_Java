package com.lebi.model;

import java.util.Date;

public class Agenda {
	private int id;
	private Date horario;
	private String dia;	
	
	public Agenda(int id, Date horario, String dia) {
		this.id = id;
		this.horario = horario;
		this.dia = dia;
	}
	
	public int getId() {return id;}
	public void setId(int id) {this.id = id;}
	
	public Date getHorario() {return horario;}
	public void setHorario(Date horario) {this.horario = horario;}
	
	public String getDia() {return dia;}
	public void setDia(String dia) {this.dia = dia;}
}
