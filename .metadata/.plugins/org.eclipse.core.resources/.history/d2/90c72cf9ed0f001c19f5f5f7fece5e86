package com.lebi.dao;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.lebi.model.Agenda;
import com.lebi.model.AgendaMedico;
import com.lebi.model.Medico;

public class AgendaEspecialistaDao {

	BancoDeDados bd = new BancoDeDados();
	public Statement st = null;
	public ResultSet rs = null;

	public List<AgendaMedico> listarAgenda() {
		List<AgendaMedico> consultasMedico = new ArrayList<>();

		bd.conectar();
		if (bd.estaConectado()) {
			try {
				String query = "select m.especialidade, m.nome, a.dia, a.horario from agenda_medico am, medicos m, agenda a "
						+ "where am.idMedico = m.id " + "and am.idAgenda = a.id order by m.especialidade";

				st = bd.getConnection().createStatement();
				rs = st.executeQuery(query);

				while (rs.next()) {
					AgendaMedico ag = new AgendaMedico();

					Medico medico = new Medico();
					medico.setEspecialidade(rs.getString("especialidade"));
					medico.setNome(rs.getString("nome"));

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
			System.out.println("Não foi possível conectar ao banco de dados");
		}

		bd.desconectar();
		return consultasMedico;
	}

	public List<AgendaMedico> listaFiltrada(String especialidade) {
		List<AgendaMedico> consultasMedico = new ArrayList<>();

		bd.conectar();
		if (bd.estaConectado()) {
			try {
				String query = "select m.especialidade, m.nome, a.dia, a.horario from agenda_medico am, medicos m, agenda a "
						+ "where am.idMedico = m.id " + "and am.idAgenda = a.id " + "and m.especialidade = '"
						+ especialidade + "'";

				st = bd.getConnection().createStatement();
				rs = st.executeQuery(query);

				while (this.rs.next()) {
					AgendaMedico ag = new AgendaMedico();

					Medico medico = new Medico();
					medico.setEspecialidade(rs.getString("especialidade"));
					medico.setNome(rs.getString("nome"));

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
			System.out.println("Não foi possível conectar ao banco de dados");
		}

		bd.desconectar();
		return consultasMedico;
	}

}
