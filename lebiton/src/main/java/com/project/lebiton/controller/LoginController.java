package com.project.lebiton.controller;

import com.project.lebiton.model.Paciente;
import com.project.lebiton.model.Sessao;
import com.project.lebiton.model.Usuario;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    @FXML
    public TextField txLogin;
    @FXML
    public PasswordField txSenha;
    @FXML
    public Button btLogar;
    @FXML
    public Button btSair;
    @FXML
    public Button btCadastrar;

    private javax.swing.JOptionPane JOptionPane;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
    }

    @FXML
    public void logar(ActionEvent actionEvent) {
        Usuario user = new Usuario(txLogin.getText(), txSenha.getText());
        user = user.login();
        if (user != null) {
            Stage stage = (Stage) btLogar.getScene().getWindow();

            // Validando todos os campos do login como obrigat�rios.
            if (txLogin.getText().equals("") && txSenha.getText().equals("")) {
                javax.swing.JOptionPane.showMessageDialog(null, "Os campos [Usu�rio] e [Senha] s�o obrigat�rios!", "AVISO",
                        javax.swing.JOptionPane.WARNING_MESSAGE);
                return;
            }

            // Se os campos n�o forem vazios, o cadastro do paciente � realizado. Se forem
            // vazios, entra no if de cima.
            try {
                if (user instanceof Paciente) {
                    Sessao.getInstance().setEmail(txLogin.getText());
                    FXMLLoader root = new FXMLLoader(LoginController.class.getResource("/com/project/lebiton/view/Paciente.fxml"));

                    Scene scene = new Scene(root.load(), 700, 540);
                    stage.setScene(scene);
                    stage.setTitle("Tela do Paciente");
                    stage.show();
                    System.out.println("Logado");

                }

            } catch (IOException e) {
                e.printStackTrace();

            }

        } else {
            System.out.println("Usu�rio/senha inv�lido!");

            // O alert criado abaixo � como se fosse uma esp�cie de "janela", criada a
            // partir dos set.
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Login Inv�lido!");
            alert.setTitle("ERRO AO LOGAR!");
            alert.setContentText("Usu�rio/Senha inv�lidos! Tente novamente.");
            alert.show();
        }
    }

    @FXML
    public void cadastrarPaciente(ActionEvent actionEvent) {

        Stage stage = (Stage) btCadastrar.getScene().getWindow();

        try {
            FXMLLoader root = new FXMLLoader(LoginController.class.getResource("/com/project/lebiton/view/CadastroPaciente.fxml"));
            Scene scene = new Scene(root.load());
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void sairSistema(ActionEvent actionEvent) {
        Platform.exit();
    }
}
