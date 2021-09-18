package com.project.lebiton.dao;

import com.project.lebiton.model.UsuarioInterface;

public interface UsuarioRepository {

    boolean login(final String usuario, final String senha);
    boolean createUser(final UsuarioInterface usuario);
}
