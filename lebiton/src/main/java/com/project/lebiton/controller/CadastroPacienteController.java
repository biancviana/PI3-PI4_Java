package com.project.lebiton.controller;

import com.project.lebiton.Main;
import com.project.lebiton.dao.PacienteDaoInterface;
import com.project.lebiton.dao.factory.FactoryPacienteDAO;
import com.project.lebiton.handleError.ErrorHandle;
import com.project.lebiton.model.impl.Paciente;
import com.project.lebiton.utils.RequestField;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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
            alert.setContentText("Usu�rio/Senha validados! Prossiga.");
            alert.show();
        } else {
            System.out.println("Ocorreu um erro!");

            final Alert alert = new Alert(AlertType.ERROR);
            alert.setHeaderText("Cadastro Inv�lido!");
            alert.setTitle("ERRO AO CADASTRAR!");
            alert.setContentText("N�o conseguimos processar seu cadastro! Tente novamente.");
            alert.show();
        }
    }

    @FXML
    public void voltarLogin() throws IOException {
        final Main principal = new Main();
        principal.start(new Stage());
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
        final RequestField field = new RequestField();
        final List<RequestField> request = new ArrayList<>();

        final List<String> key = Arrays.asList("nome", "data de Nascimento", "cpf", "telefone", "email", "senha");
        final List<String> value = Arrays.asList(txNome.getText(), txDataNascimento.getText(), txCpf.getText(), txTelefone.getText(), txEmail.getText(), txSenha.getText());

        for (int i = 0; i <= key.size(); i++) {
            field.setKey(key.get(i));
            field.setKey(value.get(i));

            request.add(field);
        }

        return request;
    }

}