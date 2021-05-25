package com.lebi.model;

public class AgendaPaciente {
	private int id;
	private Paciente paciente;
	private Medico medico;
	private AgendaMedico agenda_medico;
	
	public AgendaPaciente(int id, Paciente paciente, Medico medico, AgendaMedico agenda_medico) {
		this.id = id;
		this.paciente = paciente;
		this.medico = medico;
		this.agenda_medico = agenda_medico;
	}
	
	public int getId() {return id;}
	public void setId(int id) {this.id = id;}
	
	public Paciente getPaciente() {return paciente;}
	public void setPaciente(Paciente paciente) {this.paciente = paciente;}
	
	public Medico getMedico() {return medico;}
	public void setMedico(Medico medico) {this.medico = medico;}
	
	public AgendaMedico getAgenda_medico() {return agenda_medico;}
	public void setAgenda_medico(AgendaMedico agenda_medico) {this.agenda_medico = agenda_medico;}
	
	
}
