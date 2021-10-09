package com.project.lebiton.model.impl;

import com.project.lebiton.dao.LoginDaoInterface;
import com.project.lebiton.dao.factory.FactoryLoginDAO;
import com.project.lebiton.model.UsuarioInterface;

import javafx.beans.property.StringProperty;

public class Administrador extends Usuario implements UsuarioInterface{
	
	public Administrador() {
	}
	
	public Administrador(final String email, final String senha) {
		super(email, senha);
	}
	
	public Administrador(final StringProperty nome, final String telefone,
            final String senha, final String email) {
			super(nome, telefone, senha, email);
	}

	@Override
	public boolean logar() {
		final LoginDaoInterface dao = FactoryLoginDAO.criarLogindao();
		return dao.login(this.email, this.senha);
	}

	@Override
	public boolean createUser(UsuarioInterface usuario) {
		return false;
	}

}
