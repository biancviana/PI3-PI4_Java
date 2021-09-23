package com.project.lebiton.controller;

import com.project.lebiton.dao.MedicoDaoInterface;
import com.project.lebiton.dao.factory.FactoryMedicoDAO;
import com.project.lebiton.handleError.ErrorHandle;
import com.project.lebiton.model.impl.Medico;
import com.project.lebiton.utils.RequestField;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

public class CadastroMedicoController implements Initializable {

    @FXML
    TextField txNome;
    @FXML
    TextField txDataNascimento;
    @FXML
    TextField txCrm;
    @FXML
    TextField txEspecialidade;
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

    @FXML
    public void cadastrar() throws Exception {

        //Verifica se campos são validos
        ErrorHandle.checkFields(setFieldList());

        final MedicoDaoInterface dao = FactoryMedicoDAO.criarMedicodao();

        if (dao.createUser(this.setMedicoBuider())) {
            System.out.println("Paciente cadastrado!");

            final Alert alert = new Alert(AlertType.INFORMATION);
            alert.setHeaderText("Paciente cadastrado com sucesso!");
            alert.setTitle("CADASTRO REALIZADO!");
            alert.setContentText("Usuário/Senha validados! Prossiga.");
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

    private Medico setMedicoBuider() {
        return new Medico.Builder()
                .nome(txNome.getText())
                .email(txEmail.getText())
                .telefone(txTelefone.getText())
                .senha(txSenha.getText())
                .especialidade(txEspecialidade.getText())
                .crm(txCrm.getText())
                .build();
    }

    private List<RequestField> setFieldList() {
        final List<RequestField> request = new ArrayList<>();
        final List<String> key = Arrays.asList("nome", "data de Nascimento", "cpf", "telefone", "email", "senha");
        final List<String> value = Arrays.asList(txNome.getText(), txDataNascimento.getText(), txCrm.getText(), txEspecialidade.getText(), txTelefone.getText(), txEmail.getText(), txSenha.getText());

        for (int i = 0; i < key.size(); i++) {
            final RequestField field = new RequestField();
            field.setKey(key.get(i));
            field.setValue(value.get(i));

            request.add(field);
        }

        return request;
    }

}
