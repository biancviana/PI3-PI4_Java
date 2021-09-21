package com.project.lebiton.model.impl;

import com.project.lebiton.dao.LoginDaoInterface;
import com.project.lebiton.dao.factory.FactoryLoginDAO;
import com.project.lebiton.model.UsuarioInterface;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Medico extends Usuario implements UsuarioInterface {

	private StringProperty especialidade;
	private StringProperty crm;

	public Medico(final String email, final String senha) {
		super(email, senha);
	}

	public Medico() {}


	public Medico(final StringProperty nome, final String email, final String telefone, final String senha, final String endereco, final StringProperty especialidade, final StringProperty crm) {
		super(nome, email, telefone, senha, endereco);
		this.especialidade = especialidade;
		this.crm = crm;
	}

	public StringProperty getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(final String especialidade) {
		this.especialidade = new SimpleStringProperty("");
		this.especialidade.set(especialidade);
	}

	@Override
	public boolean logar() {
		final LoginDaoInterface dao = FactoryLoginDAO.criarLogindao();
		return dao.login(this.email, this.senha);
	}
}
