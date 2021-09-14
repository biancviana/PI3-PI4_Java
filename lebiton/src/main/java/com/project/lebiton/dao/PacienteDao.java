package com.project.lebiton.dao;

import com.project.lebiton.dao.connction.ConnectionFactory;
import com.project.lebiton.model.AgendaPaciente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PacienteDao {

    private Connection connection;

    public boolean cadastrarConsulta(AgendaPaciente agendaPaciente) {
        try {
            connection = ConnectionFactory.getConnection();
            PreparedStatement statement;

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

        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }


        return false;
    }

    public List<AgendaPaciente> listarAgenda(String email) {
        List<AgendaPaciente> agenda = new ArrayList<>();

        try {
            connection = ConnectionFactory.getConnection();
            ResultSet result;
            PreparedStatement statement;

            statement = connection.prepareStatement("SELECT id, especialidade, medico, dia, horario from consulta_paciente where email = ?");
            statement.setString(1, email);

            result = statement.executeQuery();

            while (result.next()) {
                AgendaPaciente ag = new AgendaPaciente();
                ag.setId(result.getLong("id"));
                ag.setEspecialidade(result.getString("especialidade"));
                ag.setMedico(result.getString("medico"));
                ag.setDia(result.getString("dia"));
                ag.setHorario(result.getString("horario"));
                agenda.add(ag);
            }

        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }

        return agenda;
    }

    public boolean excluirConsultaAgendada(Long id) {
        try {
            connection = ConnectionFactory.getConnection();
            PreparedStatement statement;

            statement = connection.prepareStatement("delete from consulta_paciente where id = ?");
            statement.setLong(1, id);

            statement.executeUpdate();
            return true;

        } catch (Exception e) {
            System.out.println("Erro bem aqui: " + e.getMessage());
        }

        return false;
    }

}
