package com.lebi.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.lebi.dao.AgendaEspecialistaDao;
import com.lebi.dao.PacienteDao;
import com.lebi.model.AgendaMedico;
import com.lebi.model.Sessao;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.input.MouseEvent;

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
	private Button btVoltar, btAgendar;
	@FXML
	private TextField txEspecialidade, txMedico, txDia, txHorario, txUser;

	String selecao = null;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		txUser.setText(Sessao.getInstance().getEmail());
		initTable();
		initComboBox();

		cbEspecialidade.getSelectionModel().selectedItemProperty()
				.addListener((observable, oldValue, newValue) -> initTable());
	}

	@FXML
	void SelectComboBox(ActionEvent event) {
		selecao = cbEspecialidade.getSelectionModel().getSelectedItem().toString();
	}

	public void initComboBox() {
		ObservableList<String> especialidades = FXCollections.observableArrayList("cardiologia", "clinico geral",
				"dermatologia", "endocrinologia", "gastroenterologia", "ginecologia", "neurologia", "oftalmologia",
				"ortopedia", "otorrinolaringologia", "pneumologia");
		
		cbEspecialidade.setItems(especialidades);
	}

	public void initTable() {

		clMedico.setCellValueFactory(cellData -> cellData.getValue().getNomeMedico());
		clEspecialidade.setCellValueFactory(cellData -> cellData.getValue().getEspecialidade());
		clDia.setCellValueFactory(cellData -> cellData.getValue().getDia());
		clHorario.setCellValueFactory(cellData -> cellData.getValue().getHorario());

		tbAgendaEspecialista.setItems(atualizaTabela());
	}

	public ObservableList<AgendaMedico> atualizaTabela() {
		AgendaEspecialistaDao dao = new AgendaEspecialistaDao();
		if (selecao == null) {
			return FXCollections.observableArrayList(dao.listarAgenda());
		} else {
			return FXCollections.observableArrayList(dao.listaFiltrada(selecao));
		}
	}

	@FXML
	public AgendaMedico tbAgendaEspecialistaClicked(MouseEvent e) {
		int index = tbAgendaEspecialista.getSelectionModel().getSelectedIndex();
		AgendaMedico consultaSelecionada = (AgendaMedico) tbAgendaEspecialista.getItems().get(index);

		txEspecialidade.setText(consultaSelecionada.getEspecialidade().get());
		txMedico.setText(consultaSelecionada.getNomeMedico().get());
		txDia.setText(consultaSelecionada.getDia().get());
		txHorario.setText(consultaSelecionada.getHorario().get());

		return consultaSelecionada;
	}

	@FXML
	public void cadastrarConsulta() {
		PacienteDao consultaCadastrar = new PacienteDao();
		boolean agendamento = consultaCadastrar.cadastrarConsulta(txUser.getText(), txEspecialidade.getText(),
				txMedico.getText(), txDia.getText(), txHorario.getText());

		if (agendamento) {
			voltarPaciente();
		}
	}

	@FXML
	public void voltarPaciente() {
		Parent root = null;
		Stage stage = (Stage) btVoltar.getScene().getWindow();
		FXMLLoader loader = new FXMLLoader();
		try {
			root = loader.load(getClass().getResource("../view/Paciente.fxml").openStream());
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.setTitle("Tela do Paciente");
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
