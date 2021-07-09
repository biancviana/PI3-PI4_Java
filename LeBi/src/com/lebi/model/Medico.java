package com.lebi.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Medico extends Usuario {

	private StringProperty especialidade;
	private StringProperty crm;
	private StringProperty nome;

	public Medico(String nome, String email) {
		super(nome, email);
	}

	public Medico() {
		this.nome = new SimpleStringProperty("");
		this.especialidade = new SimpleStringProperty("");
	}

	public StringProperty getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(String especialidade) {
		this.especialidade.set(especialidade);
	}

	public StringProperty getCrm() {
		return crm;
	}

	public void setCrm(String crm) {
		this.crm.set(crm);
	}

	public StringProperty getNomeProperty() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome.set(nome);
	}

}
