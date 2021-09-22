package com.project.lebiton.model.impl;

import com.project.lebiton.dao.LoginDaoInterface;
import com.project.lebiton.dao.factory.FactoryLoginDAO;
import com.project.lebiton.model.UsuarioInterface;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Paciente extends Usuario implements UsuarioInterface {
    private String cpf;

    public Paciente() {
    }

    public Paciente(final String email, final String senha) {
        super(email, senha);
    }

    public Paciente(final StringProperty nome, final String cpf, final String telefone,
                    final String senha, final String email) {
        super(nome, telefone, senha, email);
        this.cpf = cpf;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(final String cpf) {
        this.cpf = cpf;
    }

    @Override
    public boolean logar() {
        final LoginDaoInterface dao = FactoryLoginDAO.criarLogindao();
        return dao.login(this.email, this.senha);
    }

    public static class Builder {

        protected StringProperty nome;
        protected String email;
        protected String telefone;
        protected String senha;
        protected String cpf;

        public Builder nome(final String nome) {
            this.nome = new SimpleStringProperty("");
            this.nome.set(nome);
            return this;
        }

        public Builder email(final String email) {
            this.email = email;
            return this;
        }

        public Builder telefone(final String telefone) {
            this.telefone = telefone;
            return this;
        }

        public Builder senha(final String senha) {
            this.senha = senha;
            return this;
        }

        public Builder cpf(final String cpf) {
            this.cpf = cpf;
            return this;
        }

        public Paciente build() { return new Paciente(nome, cpf, telefone, senha, email); }
    }
}