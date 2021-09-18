package com.project.lebiton.factory;

import com.project.lebiton.model.UsuarioInterface;
import com.project.lebiton.model.impl.Medico;
import com.project.lebiton.model.impl.Paciente;

public class UsuarioFactory {

    private final static String expression = "@medico.com";

    public static UsuarioInterface criar(final String email, final String senha) {

        if(email.contains(expression)){
            return new Medico(email, senha);
        }

        return new Paciente(email, senha);
    }
}
