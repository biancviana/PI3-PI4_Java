package com.project.lebiton.model.impl;

import com.project.lebiton.dao.LoginDaoInterface;
import com.project.lebiton.dao.factory.FactoryLoginDAO;
import com.project.lebiton.model.UsuarioInterface;

public class Administrador extends Usuario implements UsuarioInterface {

    public Administrador(final String email, final String senha) {
        super(email, senha);
    }

    @Override
    public boolean logar() {
        final LoginDaoInterface dao = FactoryLoginDAO.criarLogindao();
        return dao.login(this.email, this.senha);
    }
}
