package com.project.lebiton.model;

import java.sql.SQLException;

public interface Autenticavel {

    boolean cadastro() throws SQLException;

    Usuario login() throws SQLException, Exception;

}
