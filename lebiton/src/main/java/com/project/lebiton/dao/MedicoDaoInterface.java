package com.project.lebiton.dao;

import java.util.List;

import com.project.lebiton.model.impl.Agenda;
import com.project.lebiton.model.impl.Consulta;
import com.project.lebiton.model.impl.Medico;

public interface MedicoDaoInterface {
	boolean createUser(final Medico medico);

	 List<Agenda> listarHorarios(final String email);

	List<Consulta> listarConsultas(final String email);


}
