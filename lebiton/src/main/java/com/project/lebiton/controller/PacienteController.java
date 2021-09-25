package com.project.lebiton.controller;

import com.project.lebiton.dao.PacienteDaoInterface;
import com.project.lebiton.dao.factory.FactoryPacienteDAO;
import com.project.lebiton.model.impl.AgendaPaciente;
import com.project.lebiton.model.impl.Sessao;
import com.project.lebiton.utils.Message;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class PacienteController implements Initializable {

    @FXML
    private TableView<AgendaPaciente> tbConsultas = new TableView<>();
    @FXML
    private TableColumn<AgendaPaciente, Long> clCodigo = new TableColumn<AgendaPaciente, Long>("Código");
    @FXML
    private TableColumn<AgendaPaciente, String> clEspecialidade = new TableColumn<AgendaPaciente, String>("Especialidade");
    @FXML
    private TableColumn<AgendaPaciente, String> clMedico = new TableColumn<AgendaPaciente, String>("Médico");
    @FXML
    private TableColumn<AgendaPaciente, String> clDia = new TableColumn<AgendaPaciente, String>("Dia");
    @FXML
    private TableColumn<AgendaPaciente, String> clHorario = new TableColumn<AgendaPaciente, String>("Horário");

    @FXML
    private Button btAgendar;
    @FXML
    private TextField txUser, txEspecialista, txMedico, txDia, txHorario;

    int index;
    Long idConsulta;

    @Override
    public void initialize(final URL arg0, final ResourceBundle arg1) {
        txUser.setText(Sessao.getInstance().getEmail());

        initTable();

    }

    @FXML
    public void initTable() {
        try {
            tbConsultas.setItems(atualizaTabela());
            clCodigo.setCellValueFactory(new PropertyValueFactory<>("id"));
            clEspecialidade.setCellValueFactory(new PropertyValueFactory<>("especialidade"));
            clMedico.setCellValueFactory(new PropertyValueFactory<>("medico"));
            clDia.setCellValueFactory(new PropertyValueFactory<>("dia"));
            clHorario.setCellValueFactory(new PropertyValueFactory<>("horario"));


            tbConsultas.getColumns().setAll(clCodigo, clEspecialidade, clMedico, clDia, clHorario);


        } catch (final Exception e) {
            System.out.println("ERRO: " + e.getMessage());
        }

    }

    public ObservableList<AgendaPaciente> atualizaTabela() {
        ObservableList<AgendaPaciente> lista = null;

        try {
            final PacienteDaoInterface dao = FactoryPacienteDAO.criarPacientendao();
            lista = FXCollections.observableArrayList(dao.listarAgenda(txUser.getText()));
        } catch (final Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
        return lista;
    }

    @FXML
    public void escolherEspecialidade(final ActionEvent event) {
        final Stage stage = (Stage) btAgendar.getScene().getWindow();
        try {
            final FXMLLoader root = new FXMLLoader(PacienteController.class.getResource("/com/project/lebiton/view/AgendaEspecialista.fxml"));
            final Scene scene = new Scene(root.load(), 700, 540);
            stage.setScene(scene);
            stage.show();

        } catch (final IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public AgendaPaciente tbPacienteExcluirClicked(final MouseEvent e) {
        index = tbConsultas.getSelectionModel().getSelectedIndex();
        final AgendaPaciente consultaSelecionada = tbConsultas.getItems().get(index);

        txEspecialista.setText(consultaSelecionada.getEspecialidade());
        txMedico.setText(consultaSelecionada.getMedico());
        txDia.setText(consultaSelecionada.getDia());
        txHorario.setText(consultaSelecionada.getHorario());
        idConsulta = consultaSelecionada.getId();

        return consultaSelecionada;
    }

    @FXML
    public void excluirConsulta() {
        final PacienteDaoInterface daoInterface = FactoryPacienteDAO.criarPacientendao();
        final boolean remover = daoInterface.excluirConsultaAgendada(idConsulta);

        if (remover) {
            Message.showAlert("CONSULTA DESMARCADA COM SUCESSO!", "Consulta desmarcada!",
                    "Sua consulta foi desmarcada com sucesso!", AlertType.CONFIRMATION);

            tbConsultas.getItems().remove(index);
        }
    }

    @FXML
    public void deslogarOnClicked() {
        final Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("MENSAGEM");
        alert.setContentText("Deseja realmente sair?");

        final Optional<ButtonType> result = alert.showAndWait();

        if ((result.isPresent()) && (result.get() == ButtonType.OK)) {
            Platform.exit();
        }
    }

}
