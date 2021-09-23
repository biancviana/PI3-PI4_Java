package com.project.lebiton.controller;

import com.project.lebiton.facade.LoginFacade;
import com.project.lebiton.factory.UsuarioFactory;
import com.project.lebiton.handleError.ErrorHandle;
import com.project.lebiton.model.UsuarioInterface;
import com.project.lebiton.model.impl.Administrador;
import com.project.lebiton.model.impl.Medico;
import com.project.lebiton.model.impl.Paciente;
import com.project.lebiton.model.impl.Sessao;
import com.project.lebiton.utils.RequestField;
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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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

    final String VIEW_PATH = "/com/project/lebiton/view/";

    @Override
    public void initialize(final URL arg0, final ResourceBundle arg1) {
    }

    @FXML
    public void logar(final ActionEvent actionEvent) throws Exception {

        //Verifica se campos são validos
        ErrorHandle.checkFields(setFieldList());

        final LoginFacade facade = new LoginFacade();


        final UsuarioInterface user = UsuarioFactory.criar(txLogin.getText(), txSenha.getText());

        if (facade.logar(user)) {
            this.criarTelaParaUsuario(user);
        } else {
            System.out.println("Usuário/senha inválido!");

            final Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Login Inválido!");
            alert.setTitle("ERRO AO LOGAR!");
            alert.setContentText("Usuário/Senha inválidos! Tente novamente.");
            alert.show();
        }
    }

    @FXML
    public void cadastrarPaciente(final ActionEvent actionEvent) {
        final Stage stage = (Stage) btCadastrar.getScene().getWindow();

        try {
            final FXMLLoader root = new FXMLLoader(LoginController.class.getResource(VIEW_PATH.concat("CadastroPaciente.fxml")));
            this.abrirTela(stage, root, "Cadastrar Paciente");
        } catch (final IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void sairSistema(final ActionEvent actionEvent) {
        Platform.exit();
    }

    private void criarTelaParaUsuario(final UsuarioInterface user) throws IOException {
        final Stage stage = (Stage) btLogar.getScene().getWindow();
        Sessao.getInstance().setEmail(txLogin.getText());
        final FXMLLoader root;

        if (user instanceof Administrador) {
            root = new FXMLLoader(LoginController.class.getResource(VIEW_PATH.concat("HomeAdm.fxml")));
            this.abrirTela(stage, root, "Tela do Administrador");

        } else if (user instanceof Paciente) {
            root = new FXMLLoader(LoginController.class.getResource(VIEW_PATH.concat("Paciente.fxml")));
            this.abrirTela(stage, root, "Tela do Paciente");

        } else if (user instanceof Medico) {
            root = new FXMLLoader(LoginController.class.getResource(VIEW_PATH.concat("Medico.fxml")));
            this.abrirTela(stage, root, "Tela do Medico");
        }

        System.out.println("Login efetuado com sucesso");

    }

    private void abrirTela(final Stage stage, final FXMLLoader root, final String page) throws IOException {
        final Scene scene = new Scene(root.load(), 700, 540);
        stage.setScene(scene);
        stage.setTitle(page);
        stage.show();
    }

    private List<RequestField> setFieldList() {
        final List<RequestField> request = new ArrayList<>();
        final List<String> key = Arrays.asList("login", "senha");
        final List<String> value = Arrays.asList(txLogin.getText(), txSenha.getText());

        for (int i = 0; i < key.size(); i++) {
            final RequestField field = new RequestField();
            field.setKey(key.get(i));
            field.setValue(value.get(i));

            request.add(field);
        }

        return request;
    }
}
