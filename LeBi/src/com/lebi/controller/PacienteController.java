package com.lebi.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.lebi.Main;
import com.lebi.dao.BancoDeDados;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class PacienteController implements Initializable{
	
	@FXML private TableView tbConsultas;
	@FXML private MenuButton mbEspecialidade;
	@FXML private Button btAgendar;
	@FXML private Button btVoltar;
	

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {}
	
	BancoDeDados bd = new BancoDeDados();
	
	@FXML
	public void escolherEspecialidade(ActionEvent event) {
		Parent root = null;
		Stage stage = (Stage) btAgendar.getScene().getWindow();
		FXMLLoader loader = new FXMLLoader();
		try {
			root = loader.load(getClass().getResource("../view/AgendaEspecialista.fxml").openStream());	
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@FXML
	public void voltarMain()
	{
		Main principal = new Main();
		principal.start(new Stage());
	}
	
	

}
