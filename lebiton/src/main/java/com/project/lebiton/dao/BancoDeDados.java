package com.project.lebiton.dao;

import java.sql.*;

public class BancoDeDados {
	public Connection connection = null;
	public Statement statement = null;
	public ResultSet resultset = null;

	public void conectar() {
		String servidor = "jdbc:mysql://localhost:3306/lebiDb";
		String usuario = "root";
		String senha = "abc123.A";
		//String senha = "Leh2019";
		//String senha = "1234";

		try {
			this.connection = DriverManager.getConnection(servidor, usuario, senha);
			this.statement = this.connection.createStatement();
		} catch (Exception e) {
			System.out.println("Erro: " + e);
		}
	}

	public boolean estaConectado() {
		if (this.connection != null) {
			return true;
		} else {
			return false;
		}
	}

	public Connection getConnection() {
		return this.connection;
	}

	public void desconectar() {
		try {
			this.connection.close();
		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}

}