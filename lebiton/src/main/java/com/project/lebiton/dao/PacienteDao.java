package com.project.lebiton.dao;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.project.lebiton.model.AgendaPaciente;

public class PacienteDao {

	BancoDeDados bd = new BancoDeDados();
	public Statement st = null;
	public ResultSet rs = null;

	public boolean cadastrarConsulta(String email, String especialidade, String medico, String dia, String horario) {
		bd.conectar();
		if (bd.estaConectado()) {
			try {
				String query = "insert into consulta_paciente (email, medico, especialidade, horario, dia) "
						+ "values ('" + email + "', '" + medico + "', '" + especialidade + "', '" + horario + "', '"
						+ dia + "')";

				st = bd.getConnection().createStatement();
				st.executeUpdate(query);
				return true;

			} catch (Exception e) {
				System.out.println("Erro: " + e.getStackTrace());
				return false;
			}

		} else {
			System.out.println("N�o foi poss�vel conectar ao banco de dados");
		}

		bd.desconectar();
		return false;
	}

	public List<AgendaPaciente> listarAgenda(String email) {
		List<AgendaPaciente> agenda = new ArrayList<>();

		bd.conectar();
		if (bd.estaConectado()) {
			try {
				String query = "select id, especialidade, medico, dia, horario from consulta_paciente where email = '"
						+ email + "'";

				st = bd.getConnection().createStatement();
				rs = st.executeQuery(query);

				while (this.rs.next()) {
					AgendaPaciente ag = new AgendaPaciente();
					ag.setId(rs.getLong("id"));
					ag.setEspecialidade(rs.getString("especialidade"));
					ag.setMedico(rs.getString("medico"));
					ag.setDia(rs.getString("dia"));
					ag.setHorario(rs.getString("horario"));
					agenda.add(ag);
				}

			} catch (Exception e) {
				System.out.println("Erro: " + e.getMessage());
			}
		} else {
			System.out.println("N�o foi poss�vel conectar ao banco de dados");
		}

		bd.desconectar();
		return agenda;
	}

	public boolean excluirConsultaAgendada(Long id) {
		bd.conectar();
		if (bd.estaConectado()) {
			try {
				String query = "delete from consulta_paciente where id = " + id;

				st = bd.getConnection().createStatement();
				st.executeUpdate(query);

				return true;

			} catch (Exception e) {
				System.out.println("Erro bem aqui: " + e.getMessage());
			}
		} else {
			System.out.println("N�o foi poss�vel conectar ao banco de dados");
		}

		bd.desconectar();
		return false;
	}

}