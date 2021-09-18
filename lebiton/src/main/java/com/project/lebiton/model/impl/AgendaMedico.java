package com.project.lebiton.model.impl;

import javafx.beans.property.StringProperty;

public class AgendaMedico {

	private Usuario usuario;
	private Medico medico;
	private Agenda agenda;

	public AgendaMedico(final Medico medico, final Agenda agenda) {
		this.medico = medico;
		this.agenda = agenda;
	}

	public AgendaMedico() {
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(final Usuario usuario) {
		this.usuario = usuario;
	}

	public Medico getMedico() {
		return medico;
	}

	public void setMedico(final Medico medico) {
		this.medico = medico;
	}

	public Agenda getAgenda() {
		return agenda;
	}

	public void setAgenda(final Agenda agenda) {
		this.agenda = agenda;
	}

	/* M�todo get utilizado pelo tableView ao exibir a agenda dos especialistas */

	public StringProperty getNome() {
		return usuario.getNome();
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
