package com.project.lebiton.dao;

import com.project.lebiton.dao.connction.ConnectionFactory;
import com.project.lebiton.model.Agenda;
import com.project.lebiton.model.AgendaMedico;
import com.project.lebiton.model.Medico;
import com.project.lebiton.model.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AgendaEspecialistaDao {

    private Connection connection;

    public List<AgendaMedico> listarAgenda() {
        List<AgendaMedico> consultasMedico = new ArrayList<>();

        try {
            connection = ConnectionFactory.getConnection();
            ResultSet result;
            PreparedStatement statement;

            statement = connection.prepareStatement("SELECT * from view_agenda_medico");
            result = statement.executeQuery();

            while (result.next()) {
                AgendaMedico ag = new AgendaMedico();

                Usuario usuario = new Usuario();
                usuario.setNome(result.getString("nome"));

                Medico medico = new Medico();
                medico.setEspecialidade(result.getString("especialidade"));

                ag.setUsuario(usuario);
                ag.setMedico(medico);

                Agenda agenda = new Agenda();
                agenda.setDia(result.getString("dia"));
                agenda.setHorario(result.getString("horario"));

                ag.setAgenda(agenda);

                consultasMedico.add(ag);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return consultasMedico;
    }

    public List<AgendaMedico> listaFiltrada(final String especialidade) {
        List<AgendaMedico> consultasMedico = new ArrayList<>();

        try {
            connection = ConnectionFactory.getConnection();
            ResultSet result;
            PreparedStatement statement;

            statement = connection.prepareStatement("select * from view_agenda_medico where especialidade = ?");
            statement.setString(1, especialidade);

            result = statement.executeQuery();

            while (result.next()) {
                AgendaMedico ag = new AgendaMedico();

                Usuario usuario = new Usuario();
                usuario.setNome(result.getString("nome"));

                Medico medico = new Medico();
                medico.setEspecialidade(result.getString("especialidade"));

                ag.setUsuario(usuario);
                ag.setMedico(medico);

                Agenda agenda = new Agenda();
                agenda.setDia(result.getString("dia"));
                agenda.setHorario(result.getString("horario"));

                ag.setAgenda(agenda);

                consultasMedico.add(ag);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return consultasMedico;
    }

}
