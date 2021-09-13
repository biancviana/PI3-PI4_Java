package com.project.lebiton.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.project.lebiton.model.Agenda;
import com.project.lebiton.model.AgendaMedico;
import com.project.lebiton.model.Medico;
import com.project.lebiton.model.Usuario;

public class AgendaEspecialistaDao {

	BancoDeDados bd = new BancoDeDados();
	public Statement st = null;
	public ResultSet rs = null;

	public List<AgendaMedico> listarAgenda() {
		List<AgendaMedico> consultasMedico = new ArrayList<>();


		bd.conectar();
		if (bd.estaConectado()) {
			try {
				String query = "select * from view_agenda_medico";

				st = bd.getConnection().createStatement();
				rs = st.executeQuery(query);

				while (rs.next()) {
					AgendaMedico ag = new AgendaMedico();
					
					Usuario usuario = new Usuario();
					usuario.setNome(rs.getString("nome"));

					Medico medico = new Medico();
					medico.setEspecialidade(rs.getString("especialidade"));
					
					ag.setUsuario(usuario);
					ag.setMedico(medico);

					Agenda agenda = new Agenda();
					agenda.setDia(rs.getString("dia"));
					agenda.setHorario(rs.getString("horario"));

					ag.setAgenda(agenda);

					consultasMedico.add(ag);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("N�o foi poss�vel conectar ao banco de dados");
		}

		bd.desconectar();
		return consultasMedico;
	}

	public List<AgendaMedico> listaFiltrada(final String especialidade) {
		List<AgendaMedico> consultasMedico = new ArrayList<>();

		bd.conectar();
		if (bd.estaConectado()) {
			try {
				String query = "select * from view_agenda_medico "
						+ "where especialidade = '" + especialidade + "'";

				st = bd.getConnection().createStatement();
				rs = st.executeQuery(query);

				while (this.rs.next()) {
					AgendaMedico ag = new AgendaMedico();

					Usuario usuario = new Usuario();
					usuario.setNome(rs.getString("nome"));
					
					Medico medico = new Medico();
					medico.setEspecialidade(rs.getString("especialidade"));

					ag.setUsuario(usuario);
					ag.setMedico(medico);

					Agenda agenda = new Agenda();
					agenda.setDia(rs.getString("dia"));
					agenda.setHorario(rs.getString("horario"));

					ag.setAgenda(agenda);

					consultasMedico.add(ag);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("N�o foi poss�vel conectar ao banco de dados");
		}

		bd.desconectar();
		return consultasMedico;
	}

}