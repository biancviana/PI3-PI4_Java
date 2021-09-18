package com.project.lebiton.dao.impl;

import com.project.lebiton.dao.UsuarioRepository;
import com.project.lebiton.dao.connction.ConnectionFactory;
import com.project.lebiton.model.UsuarioInterface;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDao implements UsuarioRepository {

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
    public boolean createUser(final UsuarioInterface usuario) {
        return false;
    }

//    public Usuario login(final String usuario, final String senha) {
//        Usuario user = null;
//
//        try {
//            connection = ConnectionFactory.getConnection();
//            final ResultSet result;
//            final PreparedStatement statement;
//
//            statement = connection.prepareStatement("SELECT * FROM usuario where email = ? and senha = ?");
//            statement.setString(1, usuario);
//            statement.setString(2, senha);
//
//            result = statement.executeQuery();
//
//            if (result.next()) {
//                user = new Paciente(result.getString("nome"), result.getString("email"));
//                ;
//            }
//
//            ConnectionFactory.closeConnection(connection, statement);
//
//        } catch (final SQLException ex) {
//            System.out.println("Erro: " + ex.getStackTrace());
//        }
//
//        return user;
//    }
//
//
//    public boolean createUser(final Paciente paciente) {
//        try {
//            connection = ConnectionFactory.getConnection();
//            final PreparedStatement statement;
//
//            statement = connection.prepareStatement("insert into pacientes (nome, email, cpf, telefone, endereco, senha) values (?,?,?,?,?,?)");
//            statement.setString(1, paciente.getNome().toString());
//            statement.setString(2, paciente.getEmail());
//            statement.setString(3, paciente.getCpf());
//            statement.setString(4, paciente.getTelefone());
//            statement.setString(5, paciente.getEndereco());
//            statement.setString(6, paciente.getSenha());
//
//            if (!statement.execute()) {
//                return true;
//            }
//
//            ConnectionFactory.closeConnection(connection, statement);
//
//        } catch (final Exception e) {
//            System.out.println("Erro: " + e.getStackTrace());
//        }
//
//        return false;
//    }

}
