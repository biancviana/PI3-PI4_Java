package com.project.lebiton.dao.impl;

import com.project.lebiton.dao.AdministradorDaoInterface;
import com.project.lebiton.dao.connction.ConnectionFactory;
import com.project.lebiton.model.impl.Agenda;
import com.project.lebiton.model.impl.AgendaMedico;
import com.project.lebiton.model.impl.Medico;
import com.project.lebiton.model.impl.Paciente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AdministradorDao implements AdministradorDaoInterface {
    private Connection connection;

    @Override
    public List<Medico> listarMedicos() {
        final List<Medico> medico = new ArrayList<Medico>();

        try {
            connection = ConnectionFactory.getConnection();
            final ResultSet result;
            final PreparedStatement statement;

            statement = connection.prepareStatement("select u.nome, especialidade, crm\n" +
                    "from medicos m\n" +
                    "inner join usuario u on u.id = m.idUsuario " );
            result = statement.executeQuery();

            while (result.next()) {
                final Medico md = new Medico();
                md.setNome(result.getString("nome"));
                md.setEspecialidade(result.getString("especialidade"));
                md.setCrm(result.getString("crm"));
                medico.add(md);
            }
        }catch (final Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }

        return medico;
    }

    @Override
    public List<Agenda> listarAgenda() {
        final List<Agenda> agenda = new ArrayList<Agenda>();

        try {
            connection = ConnectionFactory.getConnection();
            final ResultSet result;
            final PreparedStatement statement;

            statement = connection.prepareStatement("select dia, horario from agenda ");
            result = statement.executeQuery();

            while (result.next()) {
                final Agenda ag = new Agenda();
                ag.setDia(result.getString("dia"));
                ag.setHorario(result.getString("horario"));
                agenda.add(ag);
            }
        }catch (final Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
        return agenda;
    }

    @Override
    public List<Paciente> listarPacientes() {
        final List<Paciente> paciente = new ArrayList<Paciente>();

        try {
            connection = ConnectionFactory.getConnection();
            final ResultSet result;
            final PreparedStatement statement;

            statement = connection.prepareStatement("select nome from usuario\n" +
                    "where email like '%@paciente.com%'\n" );
            result = statement.executeQuery();

            while (result.next()) {
                final Paciente p = new Paciente();
                p.setNome(result.getString("nome"));
                paciente.add(p);
            }
        }catch (final Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }

        return paciente;
    }

    @Override
    public boolean createAgendaMedico(AgendaMedico agMedico) {
        try{
            connection = ConnectionFactory.getConnection();
            final PreparedStatement statement;

            statement = connection.prepareStatement("call createAgendaMedico(?,?,?)");
            statement.setString(1, agMedico.getMedico().getNome().get());
            statement.setString(2, agMedico.getAgenda().getHorario().get());
            statement.setString(3, agMedico.getAgenda().getDia().get());

            if (!statement.execute()) {
                return true;
            }

            ConnectionFactory.closeConnection(connection, statement);

        }catch (final Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
        return false;
    }


}
