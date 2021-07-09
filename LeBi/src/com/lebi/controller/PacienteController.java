package com.lebi.controller;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import com.lebi.Main;
import com.lebi.dao.PacienteDao;
import com.lebi.model.AgendaPaciente;
import com.lebi.model.Sessao;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class PacienteController implements Initializable {

	@FXML
	private TableView<AgendaPaciente> tbConsultas = new TableView<>();
	@FXML
	private TableColumn<AgendaPaciente, Long> clCodigo = new TableColumn<AgendaPaciente, Long>("C�digo");
	@FXML
	private TableColumn<AgendaPaciente, String> clEspecialidade = new TableColumn<AgendaPaciente, String>(
			"Especialidade");
	@FXML
	private TableColumn<AgendaPaciente, String> clMedico = new TableColumn<AgendaPaciente, String>("M�dico");
	@FXML
	private TableColumn<AgendaPaciente, String> clDia = new TableColumn<AgendaPaciente, String>("Dia");
	@FXML
	private TableColumn<AgendaPaciente, String> clHorario = new TableColumn<AgendaPaciente, String>("Hor�rio");

	@FXML
	private Button btAgendar, btDeslogar, btDesmarcar;
	@FXML
	private TextField txUser, txEspecialista, txMedico, txDia, txHorario;

	int index;
	Long idConsulta;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		txUser.setText(Sessao.getInstance().getEmail());

		initTable();

	}

	@SuppressWarnings("unchecked")
	@FXML
	public void initTable() {
		tbConsultas.setItems(atualizaTabela());
		clCodigo.setCellValueFactory(new PropertyValueFactory<AgendaPaciente, Long>("id"));
		clEspecialidade.setCellValueFactory(new PropertyValueFactory<AgendaPaciente, String>("especialidade"));
		clMedico.setCellValueFactory(new PropertyValueFactory<AgendaPaciente, String>("medico"));
		clDia.setCellValueFactory(new PropertyValueFactory<AgendaPaciente, String>("dia"));
		clHorario.setCellValueFactory(new PropertyValueFactory<AgendaPaciente, String>("horario"));

		tbConsultas.getColumns().setAll(clCodigo, clEspecialidade, clMedico, clDia, clHorario);
	}

	public ObservableList<AgendaPaciente> atualizaTabela() {
		PacienteDao dao = new PacienteDao();
		return FXCollections.observableArrayList(dao.listarAgenda(txUser.getText()));
	}

	@FXML
	public void escolherEspecialidade(ActionEvent event) {
		Parent root = null;
		Stage stage = (Stage) btAgendar.getScene().getWindow();
		FXMLLoader loader = new FXMLLoader();
		try {
			root = loader.load(getClass().getResource("../view/AgendaEspecialista.fxml").openStream());
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@FXML
	public AgendaPaciente tbPacienteExcluirClicked(MouseEvent e) {
		index = tbConsultas.getSelectionModel().getSelectedIndex();
		AgendaPaciente consultaSelecionada = (AgendaPaciente) tbConsultas.getItems().get(index);

		txEspecialista.setText(consultaSelecionada.getEspecialidade());
		txMedico.setText(consultaSelecionada.getMedico());
		txDia.setText(consultaSelecionada.getDia());
		txHorario.setText(consultaSelecionada.getHorario());

		idConsulta = consultaSelecionada.getId();
		return consultaSelecionada;
	}

	@FXML
	public void excluirConsulta() {

		PacienteDao consultaAgendadaExcluir = new PacienteDao();
		boolean remover = consultaAgendadaExcluir.excluirConsultaAgendada(idConsulta);
		if (remover) {
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setHeaderText("Consulta desmarcada!");
			alert.setTitle("CONSULTA DESMARCADA COM SUCESSO!");
			alert.setContentText("Pronto, sua consulta foi desmarcada com sucesso!");
			alert.show();

			tbConsultas.getItems().remove(index);
		}
	}

    @FXML
    public void deslogarOnClicked() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("MENSAGEM");
        alert.setContentText("Deseja realmente sair?");

        Optional<ButtonType> result = alert.showAndWait();

        if ((result.isPresent()) && (result.get() == ButtonType.OK)) {
        	Platform.exit();
        }
    }

}
