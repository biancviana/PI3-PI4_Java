package com.project.lebiton.dao;

import com.project.lebiton.model.impl.AgendaPaciente;
import com.project.lebiton.model.impl.Paciente;

import java.util.List;

public interface PacienteDaoInterface {
    boolean createUser(final Paciente paciente);

    boolean cadastrarConsulta(final AgendaPaciente agendaPaciente);

    List<AgendaPaciente> listarAgenda(final String email);

    boolean excluirConsultaAgendada(final Long id);
}
