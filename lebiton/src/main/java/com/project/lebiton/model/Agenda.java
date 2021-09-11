package com.project.lebiton.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Agenda {
	private Long id;
	private StringProperty horario;
	private StringProperty dia;

	public Agenda(Long id, StringProperty horario, StringProperty dia) {
		this.id = id;
		this.horario = horario;
		this.dia = dia;
	}

	public Agenda() {
		this.dia = new SimpleStringProperty("");
		this.horario = new SimpleStringProperty("");
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public StringProperty getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario.set(horario);
	}

	public StringProperty getDia() {
		return dia;
	}

	public void setDia(String dia) {
		this.dia.set(dia);
	}
}
