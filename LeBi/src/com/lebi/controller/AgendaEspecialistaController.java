package com.lebi.controller;

import java.net.URL;
import java.util.ResourceBundle;

import com.lebi.dao.BancoDeDados;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;

public class AgendaEspecialistaController implements Initializable{

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {}
	
	@FXML private TableView tbAgendaEspecialista;
	
	BancoDeDados bd = new BancoDeDados();
	

}
