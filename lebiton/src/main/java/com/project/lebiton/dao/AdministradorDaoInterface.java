package com.project.lebiton.dao;

import com.project.lebiton.model.impl.Agenda;
import com.project.lebiton.model.impl.AgendaMedico;
import com.project.lebiton.model.impl.Medico;

import java.util.List;

public interface AdministradorDaoInterface {

    List<Medico> listarMedicos();

    List<Agenda> listarAgenda();

    boolean createAgendaMedico(final AgendaMedico agMedico);
}
