package com.project.lebiton.dao.impl;

import com.project.lebiton.dao.UsuarioRepository;
import com.project.lebiton.dao.connction.ConnectionFactory;
import com.project.lebiton.model.UsuarioInterface;
import com.project.lebiton.model.impl.Paciente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDao implements UsuarioRepository {

	private Connection connection;
	
	@Override
	public boolean login(String usuario, String senha) {
		// TODO Auto-generated method stub
		return false;
	}
	

	@Override
	public boolean createUser(UsuarioInterface usuario) {
		// TODO Auto-generated method stub
		return false;
	}

}
