package com.project.lebiton.controller;

import com.project.lebiton.Main;
import com.project.lebiton.dao.PacienteDaoInterface;
import com.project.lebiton.dao.factory.FactoryPacienteDAO;
import com.project.lebiton.handleError.ErrorHandle;
import com.project.lebiton.model.impl.Paciente;
import com.project.lebiton.utils.RequestField;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

public class CadastroPacienteController implements Initializable {

    @Override
    public void initialize(final URL arg0, final ResourceBundle arg1) {
    }

    @FXML
    TextField txNome;
    @FXML
    TextField txDataNascimento;
    @FXML
    TextField txCpf;
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
    public void cadastrar() throws Exception {

        //Verifica se campos são validos
        ErrorHandle.checkFields(setFieldList());

        final PacienteDaoInterface dao = FactoryPacienteDAO.criarPacientendao();

        if (dao.createUser(this.setPacienteBuilder())) {
            System.out.println("Paciente cadastrado!");

            final Alert alert = new Alert(AlertType.INFORMATION);
            alert.setHeaderText("Paciente cadastrado com sucesso!");
            alert.setTitle("CADASTRO REALIZADO!");
            alert.setContentText("Usuário/Senha validados! Volte para a tela inicial e prossiga.");
            alert.show();
        } else {
            System.out.println("Ocorreu um erro!");

            final Alert alert = new Alert(AlertType.ERROR);
            alert.setHeaderText("Cadastro Inválido!");
            alert.setTitle("ERRO AO CADASTRAR!");
            alert.setContentText("Não conseguimos processar seu cadastro! Tente novamente.");
            alert.show();
        }
    }

    @FXML
    public void voltarLogin() {
    	final Stage stage = (Stage) btVoltar.getScene().getWindow();
        try {

            final FXMLLoader root = new FXMLLoader(CadastroPacienteController.class.getResource("/com/project/lebiton/view/Login.fxml"));
            final Scene scene = new Scene(root.load(), 700, 540);
            stage.setScene(scene);
            stage.setTitle("Tela de Login");
            stage.show();

        } catch (final IOException e) {
            e.printStackTrace();
        }
    }

    private Paciente setPacienteBuilder() {
        return new Paciente.Builder()
                .nome(txNome.getText())
                .cpf(txCpf.getText())
                .telefone(txTelefone.getText())
                .email(txEmail.getText())
                .senha(txSenha.getText())
                .build();
    }

    private List<RequestField> setFieldList() {
        final List<RequestField> request = new ArrayList<>();
        final List<String> key = Arrays.asList("nome", "data de Nascimento", "cpf", "telefone", "email", "senha");
        final List<String> value = Arrays.asList(txNome.getText(), txDataNascimento.getText(), txCpf.getText(), txTelefone.getText(), txEmail.getText(), txSenha.getText());

        for (int i = 0; i < key.size(); i++) {
            final RequestField field = new RequestField();
            field.setKey(key.get(i));
            field.setValue(value.get(i));

            request.add(field);
        }

        return request;
    }

}