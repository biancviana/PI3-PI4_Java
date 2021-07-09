package com.lebi.model;

import javafx.beans.property.StringProperty;

public class AgendaMedico {

	private Medico medico;
	private Agenda agenda;

	public AgendaMedico(Medico medico, Agenda agenda) {
		this.medico = medico;
		this.agenda = agenda;
	}

	public AgendaMedico() {
	}

	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}

	public Agenda getAgenda() {
		return agenda;
	}

	public void setAgenda(Agenda agenda) {
		this.agenda = agenda;
	}

	/* Método get utilizado pelo tableView ao exibir a agenda dos especialistas */

	public StringProperty getNomeMedico() {
		return medico.getNomeProperty();
	}

	public StringProperty getEspecialidade() {
		return medico.getEspecialidade();
	}

	public StringProperty getDia() {
		return agenda.getDia();
	}

	public StringProperty getHorario() {
		return agenda.getHorario();
	}
}
