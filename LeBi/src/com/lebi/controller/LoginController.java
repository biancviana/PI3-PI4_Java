package com.lebi.controller;

import java.net.URL;
import java.util.ResourceBundle;

import com.lebi.dao.BancoDeDados;
import com.lebi.dao.LoginDao;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;


public class LoginController implements Initializable {
	
	@FXML private TextField txLogin;
	@FXML private TextField txSenha;	
	@FXML private Button btLogar;
	@FXML private Button btCadastrar;
	
	BancoDeDados bd = new BancoDeDados();

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
	}
	
	@FXML
	public void logar() {	
		LoginDao lg = new LoginDao();
		lg.login(txLogin.getText(), txSenha.getText());
	}

}
