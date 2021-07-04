package com.lebi.dao;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.lebi.model.AgendaMedico;

public class AgendaEspecialistaDao {
	
	BancoDeDados bd = new BancoDeDados();
	public Statement st = null;
	public ResultSet rs = null;
	
	public List<AgendaMedico> listarAgenda() {
		List<AgendaMedico> agenda = new ArrayList<>();
		
		bd.conectar();
		if(bd.estaConectado()) {
		try {
			String query = "select m.especialidade, m.nome, a.dia, a.horario from agenda_medico am, medicos m, agenda a " + 
					"where am.idMedico = m.id " + 
					"and am.idAgenda = a.id order by m.especialidade";
			
			st = bd.getConnection().createStatement();
			rs = st.executeQuery(query);
			
			while(this.rs.next()) {
				AgendaMedico ag = new AgendaMedico();
				ag.setEspecialidade(rs.getString("especialidade"));
				ag.setNome(rs.getString("nome"));
				ag.setDia(rs.getString("dia"));
				ag.setHorario(rs.getString("horario"));
				agenda.add(ag);
			}
		} catch(Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
		} else {
			System.out.println("Não foi possível conectar ao banco de dados");
		}
		
		bd.desconectar();
		return agenda;	
	}
	
	public List<AgendaMedico> listaFiltrada(String especialidade){
		List<AgendaMedico> agenda = new ArrayList<>();
		
		bd.conectar();
		if(bd.estaConectado()) {
		try {
			String query = "select m.especialidade, m.nome, a.dia, a.horario from agenda_medico am, medicos m, agenda a " + 
					"where am.idMedico = m.id " + 
					"and am.idAgenda = a.id " +
					"and m.especialidade = '" + especialidade + "'" ;
			
			st = bd.getConnection().createStatement();
			rs = st.executeQuery(query);
			
			while(this.rs.next()) {
				AgendaMedico ag = new AgendaMedico();
				ag.setEspecialidade(rs.getString("especialidade"));
				ag.setNome(rs.getString("nome"));
				ag.setDia(rs.getString("dia"));
				ag.setHorario(rs.getString("horario"));
				agenda.add(ag);
			}
		} catch(Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
		} else {
			System.out.println("Não foi possível conectar ao banco de dados");
		}
		
		bd.desconectar();
		return agenda;	
	}

}
