package com.lebi.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class BancoDeDados {
	public Connection connection = null;
	public Statement statement = null;
	public ResultSet resultset = null;
	
	public void conectar() {
		String servidor = "jdbc:mysql://localhost:3306/lebi";
		String usuario = "root";
		//String senha = "Leh2019";
		String senha = "1234";
		String driver = "com.mysql.jdbc.Driver";
		try {
			Class.forName(driver);
			this.connection = DriverManager.getConnection(servidor, usuario, senha);
			this.statement = this.connection.createStatement();
		}catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}
	public boolean estaConectado() {
		if(this.connection != null) {
			return true;
		} else {
			return false;
		}
	}
	
	public Connection getConnection() {
		return this.connection;
	}
	
	
	public void listarAgenda() {
		try {
			String query = "SELECT * FROM agenda";
			this.resultset = this.statement.executeQuery(query);
			while(this.resultset.next()) {
				System.out.println("ID: " + this.resultset.getString("id") + "- Horário: " + this.resultset.getString("horario") + "- Dia: " + this.resultset.getString("dia"));
			}
		} catch(Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}
	
	public void desconectar() {
		try {
			this.connection.close();
		} catch(Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}

}
