package com.lebi.dao;

import java.sql.ResultSet;
import java.sql.Statement;

import com.lebi.model.Paciente;
import com.lebi.model.Usuario;

import javafx.beans.property.StringProperty;

public class UsuarioDao {

	BancoDeDados bd = new BancoDeDados();
	
	public Usuario login(String usuario, String senha) {		
		bd.conectar();
		Usuario user = null;
		if(bd.estaConectado()) {
		
			try {
				String query = "SELECT * FROM usuario where email = '" + usuario + "' and senha = '" + senha + "'";
				Statement st = bd.getConnection().createStatement();
				ResultSet rs = st.executeQuery(query);
				while(rs.next()) {
					//int tipo = Integer.parseInt(rs.getString("tipo"));
					//if(tipo == 1) {
						user = new Paciente(rs.getString("nome"), rs.getString("email"));
					//}				
				}
								
			 }catch(Exception e) {
				System.out.println("Erro: " + e.getStackTrace());
			}
			
			bd.desconectar();
			
		} else {
			System.out.println("Não foi possível conectar ao banco de dados");
		}
		
		return user;			
	}
	
	
	public boolean cadastrar(StringProperty nome, String cpf, String telefone, String endereco, String senha, String email ) {
		bd.conectar();
		
		if(bd.estaConectado()) {
			try {
				String query = "insert into pacientes (nome, email, cpf, telefone, endereco, senha) "
						+ "values('" + nome + "', '" + email + "', '" + cpf + "', '" + telefone + "', '" + endereco + "', '" + senha + "')";
				Statement st = bd.getConnection().createStatement();
				st.executeUpdate(query);
					return true;
				
			}catch(Exception e) {
				System.out.println("Erro: " + e.getStackTrace());
				return false;	
			}
		}
		else {
			System.out.println("Não foi possível conectar ao banco de dados");		
		}
		bd.desconectar();
		return false;
			
		
	}

}
