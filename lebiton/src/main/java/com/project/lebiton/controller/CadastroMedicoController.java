package com.project.lebiton.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class CadastroMedicoController implements Initializable{
	
	@FXML
    TextField txNome;
    @FXML
    TextField txDataNascimento;
    @FXML
    TextField txCpf;
    @FXML
    TextField txEndereco;
    @FXML
    TextField txTelefone;
    @FXML
    TextField txEmail;
    @FXML
    TextField txSenha;
    @FXML
    Button btCadastrar;
    @FXML
    Button btVoltar;


	@Override
	public void initialize(final URL arg0, final ResourceBundle arg1) {
		
	}

}
