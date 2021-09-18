package com.project.lebiton.controller;

import com.project.lebiton.facade.LoginFacade;
import com.project.lebiton.factory.UsuarioFactory;
import com.project.lebiton.model.UsuarioInterface;
import com.project.lebiton.model.impl.Medico;
import com.project.lebiton.model.impl.Paciente;
import com.project.lebiton.model.impl.Sessao;
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

    FXMLLoader root = null;
    final LoginFacade facade = new LoginFacade();

    @Override
    public void initialize(final URL arg0, final ResourceBundle arg1) {
    }

    @FXML
    public void logar(final ActionEvent actionEvent) {

        // Validando todos os campos do login como obrigat�rios.
        if (txLogin.getText().equals("") && txSenha.getText().equals("")) {
            javax.swing.JOptionPane.showMessageDialog(null, "Os campos [Usu�rio] e [Senha] s�o obrigat�rios!", "AVISO",
                    javax.swing.JOptionPane.WARNING_MESSAGE);
            return;
        }

        final UsuarioInterface user = UsuarioFactory.criar(txLogin.getText(), txSenha.getText());

//            O alert criado abaixo �como se fosse uma esp�cie de "janela", criada a
//            partir dos set.
        try {
            if (!facade.logar(user)) {
                System.out.println("Usu�rio/senha inv�lido!");

                final Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText("Login Inv�lido!");
                alert.setTitle("ERRO AO LOGAR!");
                alert.setContentText("Usu�rio/Senha inv�lidos! Tente novamente.");
                alert.show();
            }

            // Se os campos n�o forem vazios, o cadastro do paciente � realizado. Se forem
            // vazios, entra no if de cima.
            final Stage stage = (Stage) btLogar.getScene().getWindow();
            Sessao.getInstance().setEmail(txLogin.getText());

            String tela = "Paciente.fxml";
            if (user instanceof Paciente) {
                root = new FXMLLoader(LoginController.class.getResource("/com/project/lebiton/view/".concat(tela)));

                final Scene scene = new Scene(root.load(), 700, 540);
                stage.setScene(scene);
                stage.setTitle("Tela do Paciente");
                stage.show();

            } else if(user instanceof Medico) {
                tela = "Medico.fxml";
                root = new FXMLLoader(LoginController.class.getResource("/com/project/lebiton/view/".concat(tela)));

                final Scene scene = new Scene(root.load(), 700, 540);
                stage.setScene(scene);
                stage.setTitle("Tela do Medico");
                stage.show();
            }

            System.out.println("Logado");

        } catch (final IOException e) {
            e.printStackTrace();

        }

    }

    @FXML
    public void cadastrarPaciente(final ActionEvent actionEvent) {

        final Stage stage = (Stage) btCadastrar.getScene().getWindow();

        try {
            final FXMLLoader root = new FXMLLoader(LoginController.class.getResource("/com/project/lebiton/view/CadastroPaciente.fxml"));
            final Scene scene = new Scene(root.load());
            stage.setScene(scene);
            stage.show();
        } catch (final IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void sairSistema(final ActionEvent actionEvent) {
        Platform.exit();
    }
}
