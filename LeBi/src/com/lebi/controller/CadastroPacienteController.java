package com.lebi.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import com.lebi.Main;
import com.lebi.dao.BancoDeDados;
import com.lebi.model.Paciente;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
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
		
		//Validando todos os campos do cadastro como obrigatórios.
		if (txNome.getText().equals(""))
		{
			JOptionPane.showMessageDialog(null, "O campo [Nome] é obrigatório!", "AVISO", JOptionPane.WARNING_MESSAGE);
			return;
		}
		
		if (txDataNascimento.getText().equals(""))
		{
			JOptionPane.showMessageDialog(null, "O campo [Data de Nascimento] é obrigatório!", "AVISO", JOptionPane.WARNING_MESSAGE);
			return;
		}
				
		if (txCpf.getText().equals(""))
		{
			JOptionPane.showMessageDialog(null, "O campo [CPF] é obrigatório!", "AVISO", JOptionPane.WARNING_MESSAGE);
			return;
		}
				
		if (txTelefone.getText().equals(""))
		{
			JOptionPane.showMessageDialog(null, "O campo [Telefone] é obrigatório!", "AVISO", JOptionPane.WARNING_MESSAGE);
			return;
		}
				
		if (txEndereco.getText().equals(""))
		{
			JOptionPane.showMessageDialog(null, "O campo [Endereço] é obrigatório!", "AVISO", JOptionPane.WARNING_MESSAGE);
			return;
		}
				
		if (txSenha.getText().equals(""))
		{
			JOptionPane.showMessageDialog(null, "O campo [Senha] é obrigatório!", "AVISO", JOptionPane.WARNING_MESSAGE);
			return;
		}
				
		if (txEmail.getText().equals(""))
		{
			JOptionPane.showMessageDialog(null, "O campo [Email] é obrigatório!", "AVISO", JOptionPane.WARNING_MESSAGE);
			return;
		}
				
	
		//Se os campos não forem vazios, o cadastro do paciente é realizado. Se forem vazios, entra no if de cima.		
		if (paciente.cadastro()) {
			System.out.println("Paciente cadastrado!");
			
			Alert alert = new Alert(AlertType.INFORMATION);			
			alert.setHeaderText("Paciente cadastrado com sucesso!");
			alert.setTitle("CADASTRO REALIZADO!");		
			alert.setContentText("Usuário/Senha inválidos! Tente novamente.");
			alert.show();
		}
		else {
			System.out.println("Ocorreu um erro!");
			
			Alert alert = new Alert(AlertType.ERROR);			
			alert.setHeaderText("Cadastro Inválido!");
			alert.setTitle("ERRO AO CADASTRAR!");			
			alert.setContentText("Não conseguimos processar seu cadastro! Tente novamente.");
			alert.show();			
		}
	}
	
	@FXML
	public void voltarLogin()
	{
		Main principal = new Main();
		principal.start(new Stage());
	}

}