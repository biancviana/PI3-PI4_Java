package com.lebi.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.lebi.controller.LoginController;

public class LoginDao {

	public boolean login(String usuario, String senha) {
		BancoDeDados bd = new BancoDeDados();
		bd.conectar();
		if(bd.estaConectado()) {
		
			try {
				String query = "SELECT * FROM pacientes where email = '" + usuario + "' and senha = '" + senha + "'";
					System.out.println("Login ok");
								
			 }catch(Exception e) {
				System.out.println("Erro: " + e.getStackTrace());
			}
			
			bd.desconectar();
			
		} else {
			System.out.println("Não foi possível conectar ao banco de dados");
		}
		return true;
		
		
	}
	
	

}
