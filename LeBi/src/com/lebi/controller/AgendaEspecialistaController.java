package com.lebi.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.lebi.Main;
import com.lebi.dao.BancoDeDados;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

public class AgendaEspecialistaController implements Initializable{

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {}
	
	@FXML private TableView tbAgendaEspecialista;
	@FXML private Button btVoltar;
	
	BancoDeDados bd = new BancoDeDados();
	
	
	@FXML
	public void voltarPaciente()
	{		
		Parent root = null;
		Stage stage = (Stage) btVoltar.getScene().getWindow();
		FXMLLoader loader = new FXMLLoader();
		try {
			root = loader.load(getClass().getResource("../view/Paciente.fxml").openStream());	
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.setTitle("Tela do Paciente");
			stage.show();
		}catch (IOException e) {
			e.printStackTrace();
		}
	}

}
