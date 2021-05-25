package com.lebi.model;

public class AgendaMedico {
	private int id;
	private int idMedico;
	private int idPaciente;
	
	public AgendaMedico(int id, int idMedico, int idPaciente) {
		this.id = id;
		this.idMedico = idMedico;
		this.idPaciente = idPaciente;
	}
	
	public int getId() {return id;}
	public void setId(int id) {this.id = id;}
	
	public int getIdMedico() {return idMedico;}
	public void setIdMedico(int idMedico) {this.idMedico = idMedico;}
	
	public int getIdPaciente() {return idPaciente;}
	public void setIdPaciente(int idPaciente) {this.idPaciente = idPaciente;}
	
	
}
