package com.project.lebiton.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.project.lebiton.dao.AgendaEspecialistaDao;
import com.project.lebiton.model.AgendaMedico;
import com.project.lebiton.dao.PacienteDao;
import com.project.lebiton.model.Sessao;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
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
		selecao = cbEspecialidade.getSelectionModel().getSelectedItem();
	}

	public void initComboBox() {
		ObservableList<String> especialidades = FXCollections.observableArrayList("cardiologia", "clinico geral",
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
		txMedico.setText(consultaSelecionada.getNome().get());
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
		Stage stage = (Stage) btVoltar.getScene().getWindow();
		try {

			FXMLLoader root = new FXMLLoader(AgendaEspecialistaController.class.getResource("/com/project/lebiton/view/Paciente.fxml"));
			Scene scene = new Scene(root.load());
			stage.setScene(scene);
			stage.setTitle("Tela do Paciente");
			stage.show();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
