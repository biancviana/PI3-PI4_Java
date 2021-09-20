package com.project.lebiton.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.project.lebiton.dao.UsuarioRepository;
import com.project.lebiton.dao.connction.ConnectionFactory;
import com.project.lebiton.model.UsuarioInterface;


public class LoginDao implements UsuarioRepository{
	
	private Connection connection;
	
	@Override
    public boolean login(final String usuario, final String senha) {
        try {
            connection = ConnectionFactory.getConnection();
            final ResultSet result;
            final PreparedStatement statement;

            statement = connection.prepareStatement("SELECT * FROM usuario where email = ? and senha = ?");
            statement.setString(1, usuario);
            statement.setString(2, senha);

            result = statement.executeQuery();

            if (result.next()) {
                return true;
            }

            ConnectionFactory.closeConnection(connection, statement, result);

        } catch (final SQLException ex) {
            System.out.println("Erro: " + ex.getStackTrace());
        }

        return false;
    }

	@Override
	public boolean createUser(UsuarioInterface usuario) {
		// TODO Auto-generated method stub
		return false;
	}

}
