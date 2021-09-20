package com.project.lebiton.model.impl;

import com.project.lebiton.dao.UsuarioRepository;
import com.project.lebiton.dao.impl.LoginDao;
import com.project.lebiton.model.UsuarioInterface;
import com.project.lebiton.service.UsuarioService;
import javafx.beans.property.StringProperty;

public class Paciente extends Usuario implements UsuarioInterface {
	private String cpf;

	private UsuarioService usuarioService;

	public Paciente() {
	}

	public String getCpf() {
		return cpf;
	}

	public Paciente(final String email, final String senha) {
		super(email, senha);

		final UsuarioRepository usuarioPersist = new LoginDao();
		usuarioService = new UsuarioService(usuarioPersist);
	}

	public Paciente(final StringProperty nome, final String cpf, final String telefone, final String endereco,
			final String senha, final String email) {
		super(nome, telefone, endereco, senha, email);
		this.cpf = cpf;
	}

	@Override
	public boolean logar() {
		return usuarioService.logar(this.email, this.senha);
	}

	@Override
	public boolean cadastrar() {
		return false;
	}
}
