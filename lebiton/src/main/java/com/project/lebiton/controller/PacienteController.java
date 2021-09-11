package com.project.lebiton.controller;

import java.io.IOException;
import java.net.URL;

import java.util.Optional;
import java.util.ResourceBundle;

import com.project.lebiton.dao.PacienteDao;
import com.project.lebiton.model.AgendaPaciente;
import com.project.lebiton.model.Sessao;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
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
	public void initialize(URL arg0, ResourceBundle arg1) {
		txUser.setText(Sessao.getInstance().getEmail());

		initTable();

	}

	@FXML
	public void initTable()  {
		try {
			tbConsultas.setItems(atualizaTabela());
			clCodigo.setCellValueFactory(new PropertyValueFactory<>("id"));
			clEspecialidade.setCellValueFactory(new PropertyValueFactory<>("especialidade"));
			clMedico.setCellValueFactory(new PropertyValueFactory<>("medico"));
			clDia.setCellValueFactory(new PropertyValueFactory<>("dia"));
			clHorario.setCellValueFactory(new PropertyValueFactory<>("horario"));


			tbConsultas.getColumns().setAll(clCodigo, clEspecialidade, clMedico, clDia, clHorario);


		} catch (Exception e) {
			System.out.println("ERRO: " + e.getMessage());
		}

	}

	public ObservableList<AgendaPaciente> atualizaTabela() {
		ObservableList<AgendaPaciente> lista = null;

		try {
			PacienteDao dao = new PacienteDao();
			lista = FXCollections.observableArrayList(dao.listarAgenda(txUser.getText()));

		} catch(Exception e) {
			System.out.println("Mais um erro: " + e.getMessage());

		}

		return lista;
	}

	@FXML
	public void escolherEspecialidade(ActionEvent event) {
		Stage stage = (Stage) btAgendar.getScene().getWindow();
		try {

			FXMLLoader root = new FXMLLoader(PacienteController.class.getResource("/com/project/lebiton/view/AgendaEspecialista.fxml"));
			Scene scene = new Scene(root.load());
			stage.setScene(scene);
			stage.show();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@FXML
	public AgendaPaciente tbPacienteExcluirClicked(MouseEvent e) {
		index = tbConsultas.getSelectionModel().getSelectedIndex();
		AgendaPaciente consultaSelecionada = tbConsultas.getItems().get(index);

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
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("MENSAGEM");
        alert.setContentText("Deseja realmente sair?");

        Optional<ButtonType> result = alert.showAndWait();

        if ((result.isPresent()) && (result.get() == ButtonType.OK)) {
        	Platform.exit();
        }
    }

}
