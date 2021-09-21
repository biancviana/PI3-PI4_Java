package com.project.lebiton.model.impl;

import com.project.lebiton.dao.LoginDaoInterface;
import com.project.lebiton.dao.factory.FactoryLoginDAO;
import com.project.lebiton.model.UsuarioInterface;
import javafx.beans.property.StringProperty;

public class Paciente extends Usuario implements UsuarioInterface {
    private String cpf;

    public Paciente() {
    }

    public String getCpf() {
        return cpf;
    }

    public Paciente(final String email, final String senha) {
        super(email, senha);
    }

    public Paciente(final StringProperty nome, final String cpf, final String telefone, final String endereco,
                    final String senha, final String email) {
        super(nome, telefone, endereco, senha, email);
        this.cpf = cpf;
    }

    @Override
    public boolean logar() {
        final LoginDaoInterface dao = FactoryLoginDAO.criarLogindao();
        return dao.login(this.email, this.senha);
    }
}
