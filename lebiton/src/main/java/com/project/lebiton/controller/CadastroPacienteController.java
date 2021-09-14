package com.project.lebiton.controller;

import com.project.lebiton.Main;
import com.project.lebiton.model.Paciente;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class CadastroPacienteController implements Initializable {

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
    }

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
    @FXML
    RadioButton rbMedico;
    @FXML
    RadioButton rbPaciente;
    @FXML
    ToggleGroup usuario;

    @FXML
    String pegarUsuarioSelecionado() {
        RadioButton radio = (RadioButton) usuario.getSelectedToggle();
        return radio.getText();
    }

    @FXML
    public void cadastrar() throws SQLException {
        Paciente paciente = new Paciente(txNome.getText(), txCpf.getText(), txTelefone.getText(), txEndereco.getText(),
                txSenha.getText(), txEmail.getText());

        // Validando todos os campos do cadastro como obrigat�rios.
        if (txNome.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "O campo [Nome] � obrigat�rio!", "AVISO", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (txDataNascimento.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "O campo [Data de Nascimento] � obrigat�rio!", "AVISO",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (txCpf.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "O campo [CPF] � obrigat�rio!", "AVISO", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (txTelefone.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "O campo [Telefone] � obrigat�rio!", "AVISO",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (txEndereco.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "O campo [Endere�o] � obrigat�rio!", "AVISO",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (txSenha.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "O campo [Senha] � obrigat�rio!", "AVISO", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (txEmail.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "O campo [Email] � obrigat�rio!", "AVISO", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Se os campos n�o forem vazios, o cadastro do paciente � realizado. Se forem
        // vazios, entra no if de cima.
        if (paciente.cadastro()) {
            System.out.println("Paciente cadastrado!");

            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setHeaderText("Paciente cadastrado com sucesso!");
            alert.setTitle("CADASTRO REALIZADO!");
            alert.setContentText("Usu�rio/Senha validados! Prossiga.");
            alert.show();
        } else {
            System.out.println("Ocorreu um erro!");

            Alert alert = new Alert(AlertType.ERROR);
            alert.setHeaderText("Cadastro Inv�lido!");
            alert.setTitle("ERRO AO CADASTRAR!");
            alert.setContentText("N�o conseguimos processar seu cadastro! Tente novamente.");
            alert.show();
        }
    }

    @FXML
    public void voltarLogin() throws IOException {
        Main principal = new Main();
        principal.start(new Stage());
    }

}