package com.project.lebiton.model;

import java.sql.SQLException;

public interface Autenticavel {

	public abstract boolean cadastro() throws SQLException;

	public abstract Usuario login() throws SQLException;

}
