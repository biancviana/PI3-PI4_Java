package com.project.lebiton.controller;

import com.project.lebiton.dao.MedicoDaoInterface;
import com.project.lebiton.dao.factory.FactoryMedicoDAO;
import com.project.lebiton.model.impl.Medico;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import javax.swing.*;
import java.net.URL;
import java.sql.SQLException;
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
    public void cadastrar() throws SQLException {

        // Validando todos os campos do cadastro como obrigat�rios.
        if (txNome.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "O campo [Nome] é obrigatório!", "AVISO", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (txDataNascimento.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "O campo [Data de Nascimento] é obrigatório!", "AVISO",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (txCrm.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "O campo [CRM] é obrigatório!", "AVISO", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (txTelefone.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "O campo [Telefone] é obrigatório!", "AVISO",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (txSenha.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "O campo [Senha] é obrigatório!", "AVISO", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (txEmail.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "O campo [Email] é obrigatório!", "AVISO", JOptionPane.WARNING_MESSAGE);
            return;
        }

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

}
