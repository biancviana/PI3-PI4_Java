package com.lebi.dao;

import java.sql.ResultSet;
import java.sql.Statement;

public class PacienteDao {
	
	BancoDeDados bd = new BancoDeDados();
	
	public void escolhaEspecialidade(String especialidade) {
		bd.conectar();
		if(bd.estaConectado()) {
			try {
				String query = "SELECT * from MEDICOS where especialidade = '" + especialidade + "'";
				Statement st = bd.getConnection().createStatement();
				ResultSet rs = st.executeQuery(query);
				while(rs.next()) {
				}
			}catch(Exception e) {
				System.out.println("Erro: " + e.getStackTrace());
			}
			
			bd.desconectar();
		}else {
			System.out.println("Não foi possível conectar ao banco de dados");
		}
	}

}
