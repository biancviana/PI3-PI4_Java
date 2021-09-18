package com.project.lebiton.service;

import com.project.lebiton.dao.UsuarioRepository;

public class UsuarioService {
    private final UsuarioRepository userRepo;

    public UsuarioService(final UsuarioRepository userRepo) {
        this.userRepo = userRepo;
    }

    public boolean logar(final String email, final String senha) {
        return userRepo.login(email, senha);
    }
}
