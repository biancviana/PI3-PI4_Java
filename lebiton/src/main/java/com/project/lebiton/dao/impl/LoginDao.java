package com.project.lebiton.dao.impl;

import com.project.lebiton.dao.LoginDaoInterface;
import com.project.lebiton.dao.connction.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class LoginDao implements LoginDaoInterface {
	
	private Connection connection;
	
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

}
