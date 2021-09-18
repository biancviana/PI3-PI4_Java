package com.project.lebiton.model.impl;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Agenda {
	private Long id;
	private final StringProperty horario;
	private final StringProperty dia;

//	public Agenda(final Long id, final StringProperty horario, final StringProperty dia) {
//		this.id = id;
//		this.horario = horario;
//		this.dia = dia;
//	}

	public Agenda() {
		this.dia = new SimpleStringProperty("");
		this.horario = new SimpleStringProperty("");
	}

	public StringProperty getHorario() {
		return horario;
	}

	public void setHorario(final String horario) {
		this.horario.set(horario);
	}

	public StringProperty getDia() {
		return dia;
	}

	public void setDia(final String dia) {
		this.dia.set(dia);
	}
}
