package com.project.lebiton.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.project.lebiton.dao.MedicoDaoInterface;
import com.project.lebiton.dao.connction.ConnectionFactory;
import com.project.lebiton.model.impl.Medico;

public class MedicoDao implements MedicoDaoInterface{
	private Connection connection;

	@Override
	public boolean createUser(final Medico medico) {
		try {
            connection = ConnectionFactory.getConnection();
            final PreparedStatement statement;

            statement = connection.prepareStatement("call insertUserMedico(?,?,?,?,?,?)");
            statement.setString(1, medico.getNome().get());
            statement.setString(2, medico.getEmail());
            statement.setString(3, medico.getTelefone());
            statement.setString(4, medico.getSenha());        
            statement.setString(5, medico.getCrm().get());
            statement.setString(6, medico.getEspecialidade().get());

            if (!statement.execute()) {
                return true;
            }

            ConnectionFactory.closeConnection(connection, statement);

        } catch (final Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }

        return false;
	}

}
