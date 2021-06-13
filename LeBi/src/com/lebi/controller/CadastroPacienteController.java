package com.lebi.controller;

import java.net.URL;
import java.util.ResourceBundle;

import com.lebi.Main;
import com.lebi.dao.BancoDeDados;
import com.lebi.model.Paciente;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class CadastroPacienteController implements Initializable{

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {}
	
	@FXML TextField txNome;
	@FXML TextField txDataNascimento;
	@FXML TextField txCpf;
	@FXML TextField txEndereco;
	@FXML TextField txTelefone;
	@FXML TextField txEmail;
	@FXML TextField txSenha;
	@FXML Button btCadastrar;
	@FXML Button btVoltar;
	
	BancoDeDados bd = new BancoDeDados();
	
	@FXML
	public void cadastrar() {
		Paciente paciente = new Paciente(txNome.getText(), txCpf.getText(), txTelefone.getText(), txEndereco.getText(), txSenha.getText(), txEmail.getText());
		
		if (paciente.cadastro()) {
			System.out.println("Paciente cadastrado!");
		}
		else {
			System.out.println("Ocorreu um erro!");
			
			
		}
	}
	
	@FXML
	public void voltarLogin()
	{
		Main principal = new Main();
		principal.start(new Stage());
	}

}