package com.project.lebiton.dao;

import com.project.lebiton.model.impl.Agenda;
import com.project.lebiton.model.impl.AgendaMedico;
import com.project.lebiton.model.impl.Medico;
import com.project.lebiton.model.impl.Paciente;

import java.util.List;

public interface AdministradorDaoInterface {

    List<Medico> listarMedicos();

    List<Agenda> listarAgenda();

    List<Paciente> listarPacientes();

    boolean createAgendaMedico(final AgendaMedico agMedico);
}
