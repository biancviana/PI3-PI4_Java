package com.project.lebiton.dao.impl;

import com.project.lebiton.dao.PacienteDaoInterface;
import com.project.lebiton.dao.connction.ConnectionFactory;
import com.project.lebiton.model.impl.AgendaPaciente;
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

            statement = connection.prepareStatement("call insertUserPaciente(?,?,?,?,?,?)");
            statement.setString(1, paciente.getNome().get());
            statement.setString(2, paciente.getEmail());
            statement.setString(3, paciente.getTelefone());
            statement.setString(4, paciente.getEndereco());
            statement.setString(5, paciente.getSenha());        
            statement.setString(6, paciente.getCpf());

            if (!statement.execute()) {
                return true;
            }

            ConnectionFactory.closeConnection(connection, statement);

        } catch (final Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }

        return false;
    }

    public boolean cadastrarConsulta(final AgendaPaciente agendaPaciente) {
        try {
            connection = ConnectionFactory.getConnection();
            final PreparedStatement statement;

            statement = connection.prepareStatement("insert into consulta_paciente (especialidade, medico, email, dia, horario) values (?,?,?,?,?)");
            statement.setString(1, agendaPaciente.getEspecialidade());
            statement.setString(2, agendaPaciente.getMedico());
            statement.setString(3, agendaPaciente.getEmail());
            statement.setString(4, agendaPaciente.getDia());
            statement.setString(5, agendaPaciente.getHorario());

            if (!statement.execute()) {
                return true;
            }

            ConnectionFactory.closeConnection(connection, statement);

        } catch (final Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }


        return false;
    }

    public List<AgendaPaciente> listarAgenda(final String email) {
        final List<AgendaPaciente> agenda = new ArrayList<>();

        try {
            connection = ConnectionFactory.getConnection();
            final ResultSet result;
            final PreparedStatement statement;

            statement = connection.prepareStatement("SELECT id, especialidade, medico, dia, horario from consulta_paciente where email = ?");
            statement.setString(1, email);

            result = statement.executeQuery();

            while (result.next()) {
                final AgendaPaciente ag = new AgendaPaciente();
                ag.setId(result.getLong("id"));
                ag.setEspecialidade(result.getString("especialidade"));
                ag.setMedico(result.getString("medico"));
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

            statement = connection.prepareStatement("delete from consulta_paciente where id = ?");
            statement.setLong(1, id);

            statement.executeUpdate();
            return true;

        } catch (final Exception e) {
            System.out.println("Erro bem aqui: " + e.getMessage());
        }

        return false;
    }

}
