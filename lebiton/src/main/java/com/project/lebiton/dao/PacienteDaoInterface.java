package com.project.lebiton.dao;

import com.project.lebiton.model.impl.Consulta;

import java.util.List;

public interface PacienteDaoInterface {
    boolean cadastrarConsulta(final Consulta consulta);

    List<Consulta> listarAgenda(final String email);

    boolean excluirConsultaAgendada(final Long id);
}
