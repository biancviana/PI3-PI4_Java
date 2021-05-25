package com.lebi.controller;

import java.net.URL;
import java.util.ResourceBundle;

import com.lebi.dao.BancoDeDados;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TableView;

public class PacienteController implements Initializable{
	
	@FXML private TableView tbConsultas;
	@FXML private MenuButton mbEspecialidade;
	

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {}
	
	BancoDeDados bd = new BancoDeDados();
	

}
