package com.project.lebiton.controller;

import com.project.lebiton.dao.AgendarEspecialistaDaoInterface;
import com.project.lebiton.dao.PacienteDaoInterface;
import com.project.lebiton.dao.factory.FactoryAgendarEspecialistalDAO;
import com.project.lebiton.dao.factory.FactoryPacienteDAO;
import com.project.lebiton.model.impl.AgendaMedico;
import com.project.lebiton.model.impl.AgendaPaciente;
import com.project.lebiton.model.impl.Sessao;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AgendaEspecialistaController implements Initializable {

    @FXML
    private TableView<AgendaMedico> tbAgendaEspecialista = new TableView<>();
    @FXML
    private TableColumn<AgendaMedico, String> clEspecialidade = new TableColumn<AgendaMedico, String>("Especialidade");
    @FXML
    private TableColumn<AgendaMedico, String> clMedico = new TableColumn<AgendaMedico, String>("Nome");
    @FXML
    private TableColumn<AgendaMedico, String> clDia = new TableColumn<AgendaMedico, String>("Dia");
    @FXML
    private TableColumn<AgendaMedico, String> clHorario = new TableColumn<AgendaMedico, String>("Horário");

    @FXML
    private ComboBox<String> cbEspecialidade = new ComboBox<>();

    @FXML
    private Button btVoltar;
    @FXML
    private TextField txEspecialidade, txMedico, txDia, txHorario, txUser;

    String selecao = null;

    @Override
    public void initialize(final URL arg0, final ResourceBundle arg1) {
        txUser.setText(Sessao.getInstance().getEmail());
        initTable();
        initComboBox();

        cbEspecialidade.getSelectionModel().selectedItemProperty()
                .addListener((observable, oldValue, newValue) -> initTable());
    }

    @FXML
    void SelectComboBox(final ActionEvent event) {
        selecao = cbEspecialidade.getSelectionModel().getSelectedItem();
    }

    public void initComboBox() {
        final ObservableList<String> especialidades = FXCollections.observableArrayList("cardiologia", "clinico geral",
                "dermatologia", "endocrinologia", "gastroenterologia", "ginecologia", "neurologia", "oftalmologia",
                "ortopedia", "otorrinolaringologia", "pneumologia");

        cbEspecialidade.setItems(especialidades);
    }

    public void initTable() {

        clMedico.setCellValueFactory(cellData -> cellData.getValue().getNome());
        clEspecialidade.setCellValueFactory(cellData -> cellData.getValue().getEspecialidade());
        clDia.setCellValueFactory(cellData -> cellData.getValue().getDia());
        clHorario.setCellValueFactory(cellData -> cellData.getValue().getHorario());

        tbAgendaEspecialista.setItems(atualizaTabela());
    }

    public ObservableList<AgendaMedico> atualizaTabela() {
        final AgendarEspecialistaDaoInterface dao = FactoryAgendarEspecialistalDAO.
                criarAgendarEspecialistaDao();

        if (selecao == null) {
            return FXCollections.observableArrayList(dao.listar());
        } else {
            return FXCollections.observableArrayList(dao.listaFiltrada(selecao));
        }
    }

    @FXML
    public AgendaMedico tbAgendaEspecialistaClicked(final MouseEvent e) {
        final int index = tbAgendaEspecialista.getSelectionModel().getSelectedIndex();
        final AgendaMedico consultaSelecionada = (AgendaMedico) tbAgendaEspecialista.getItems().get(index);

        txEspecialidade.setText(consultaSelecionada.getEspecialidade().get());
        txMedico.setText(consultaSelecionada.getNome().get());
        txDia.setText(consultaSelecionada.getDia().get());
        txHorario.setText(consultaSelecionada.getHorario().get());

        return consultaSelecionada;
    }

    @FXML
    public void cadastrarConsulta() {
        final PacienteDaoInterface dao = FactoryPacienteDAO.criarPacientendao();
        final boolean agendamento = dao.cadastrarConsulta(new AgendaPaciente(txEspecialidade.getText(),
                txMedico.getText(), txDia.getText(), txUser.getText(), txHorario.getText()));

        if (agendamento) {
            voltarPaciente();
        }
    }

    @FXML
    public void voltarPaciente() {
        final Stage stage = (Stage) btVoltar.getScene().getWindow();
        try {

            final FXMLLoader root = new FXMLLoader(AgendaEspecialistaController.class.getResource("/com/project/lebiton/view/Paciente.fxml"));
            final Scene scene = new Scene(root.load(), 700, 540);
            stage.setScene(scene);
            stage.setTitle("Tela do Paciente");
            stage.show();

        } catch (final IOException e) {
            e.printStackTrace();
        }
    }
}

