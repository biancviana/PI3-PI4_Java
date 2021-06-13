package com.lebi.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.lebi.Main;
import com.lebi.dao.BancoDeDados;
import com.lebi.model.Paciente;
import com.lebi.model.Usuario;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;


public class LoginController implements Initializable {
	
	@FXML private TextField txLogin;
	@FXML private TextField txSenha;	
	@FXML private Button btLogar;
	@FXML private Button btCadastrar;
	@FXML private Button btSair;
	
	BancoDeDados bd = new BancoDeDados();

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {}
	
	@FXML
	public void logar(){	
		Usuario user = new Usuario(txLogin.getText(), txSenha.getText());
		user = user.login();
		if(user != null) {
			Parent root = null;
			Stage stage = (Stage) btLogar.getScene().getWindow();
			FXMLLoader loader = new FXMLLoader();
			
			try {
				if(user instanceof Paciente) {
					root = loader.load(getClass().getResource("../view/Paciente.fxml").openStream());
				}
				
				Scene scene = new Scene(root);
				stage.setScene(scene);
				stage.show();
				System.out.println("Logado");
				
			} catch (IOException e) {
				e.printStackTrace();	
				
				
			}

			//DashController controller = (DashController) loader.getController();
			//controller.setTlNome(usuario);
		
		}
		else {
			System.out.println("Usuário/senha inválido!");
			
			//O alert criado abaixo é como se fosse uma espécie de "janela", criada a partir dos set.
			Alert alert = new Alert(AlertType.ERROR);
			alert.setHeaderText("ERRO!");
			alert.setTitle("Login Inválido!");
			alert.setContentText("Usuário/Senha inválidos! Tente novamente.");
			alert.show();
		}	
	}
	
	@FXML
	protected void cadastrarPaciente(ActionEvent event) {

		Parent root = null;
		Stage stage = (Stage) btCadastrar.getScene().getWindow();
		FXMLLoader loader = new FXMLLoader();
		try {
			root = loader.load(getClass().getResource("../view/CadastroPaciente.fxml").openStream());	
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
		} 	
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@FXML
	private void sairSistema() {
	 Platform.exit();
	}

}
