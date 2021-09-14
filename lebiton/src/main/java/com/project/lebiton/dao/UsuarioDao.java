package com.project.lebiton.dao;

import com.project.lebiton.dao.connction.ConnectionFactory;
import com.project.lebiton.model.Paciente;
import com.project.lebiton.model.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDao {

    private Connection connection;

    public Usuario login(String usuario, String senha) {
        Usuario user = null;

        try {
            connection = ConnectionFactory.getConnection();
            ResultSet result;
            PreparedStatement statement;

            statement = connection.prepareStatement("SELECT * FROM usuario where email = ? and senha = ?");
            statement.setString(1, usuario);
            statement.setString(2, senha);

            result = statement.executeQuery();

            if (result.next()) {
                user = new Paciente(result.getString("nome"), result.getString("email"));
                ;
            }

            ConnectionFactory.closeConnection(connection, statement);

        } catch (SQLException ex) {
            System.out.println("Erro: " + ex.getStackTrace());
        }

        return user;
    }


    public boolean createUser(Paciente paciente) {
        try {
            connection = ConnectionFactory.getConnection();
            PreparedStatement statement;

            statement = connection.prepareStatement("insert into pacientes (nome, email, cpf, telefone, endereco, senha) values (?,?,?,?,?,?)");
            statement.setString(1, paciente.getNome().toString());
            statement.setString(2, paciente.getEmail());
            statement.setString(3, paciente.getCpf());
            statement.setString(4, paciente.getTelefone());
            statement.setString(5, paciente.getEndereco());
            statement.setString(6, paciente.getSenha());

            if (!statement.execute()) {
                return true;
            }

            ConnectionFactory.closeConnection(connection, statement);

        } catch (Exception e) {
            System.out.println("Erro: " + e.getStackTrace());
        }

        return false;
    }

}
