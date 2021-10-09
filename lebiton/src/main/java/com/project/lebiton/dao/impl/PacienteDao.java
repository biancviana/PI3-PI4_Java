package com.project.lebiton.dao.impl;

import com.project.lebiton.dao.PacienteDaoInterface;
import com.project.lebiton.dao.connction.ConnectionFactory;
import com.project.lebiton.model.impl.Consulta;
import com.project.lebiton.model.impl.Paciente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PacienteDao implements PacienteDaoInterface {

    private Connection connection;
    
    public boolean createUser(final Paciente paciente) {
        try {
            connection = ConnectionFactory.getConnection();
            final PreparedStatement statement;

            statement = connection.prepareStatement("call insertUserPaciente(?,?,?,?,?)");
            statement.setString(1, paciente.getNome().get());
            statement.setString(2, paciente.getEmail());
            statement.setString(3, paciente.getTelefone());
            statement.setString(4, paciente.getSenha());        
            statement.setString(5, paciente.getCpf());

            if (!statement.execute()) {
                return true;
            }

            ConnectionFactory.closeConnection(connection, statement);

        } catch (final Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }

        return false;
    }

    public boolean cadastrarConsulta(final Consulta consulta) {
        try {
            connection = ConnectionFactory.getConnection();
            final PreparedStatement statement;

            statement = connection.prepareStatement("call createConsulta(?,?,?,?)");
            statement.setString(1, consulta.getMedico());
            statement.setString(2, consulta.getEmailPaciente());
            statement.setString(3, consulta.getDia());
            statement.setString(4, consulta.getHorario());

            if (!statement.execute()) {
                return true;
            }

            ConnectionFactory.closeConnection(connection, statement);

        } catch (final Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }


        return false;
    }

    public List<Consulta> listarAgenda(final String email) {
        final List<Consulta> agenda = new ArrayList<>();

        try {
            connection = ConnectionFactory.getConnection();
            final ResultSet result;
            final PreparedStatement statement;

            statement = connection.prepareStatement("select c.id, m.especialidade, u.nome, dia, horario " +
                    "from consulta c " +
                    "inner join usuario u on c.idMedico = u.id " +
                    "inner join medicos m on c.idMedico = m.idUsuario where emailPaciente = ? ");
            statement.setString(1, email);

            result = statement.executeQuery();

            while (result.next()) {
                final Consulta ag = new Consulta();
                ag.setId(result.getLong("id"));
                ag.setEspecialidade(result.getString("especialidade"));
                ag.setMedico(result.getString("nome"));
                ag.setDia(result.getString("dia"));
                ag.setHorario(result.getString("horario"));
                agenda.add(ag);
            }

        } catch (final Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }

        return agenda;
    }

    public boolean excluirConsultaAgendada(final Long id) {
        try {
            connection = ConnectionFactory.getConnection();
            final PreparedStatement statement;

            statement = connection.prepareStatement("delete from consulta where id = ?");
            statement.setLong(1, id);

            statement.executeUpdate();
            return true;

        } catch (final Exception e) {
            System.out.println("Erro bem aqui: " + e.getMessage());
        }

        return false;
    }

}
