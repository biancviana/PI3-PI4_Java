package com.lebi.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import com.lebi.dao.AgendaEspecialistaDao;
import com.lebi.dao.BancoDeDados;
import com.lebi.model.Agenda;
import com.lebi.model.AgendaMedico;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class AgendaEspecialistaController implements Initializable{
	
	@FXML private TableView<AgendaMedico> tbAgendaEspecialista = new TableView<>();
	@FXML private TableColumn<AgendaMedico, String> clEspecialidade = new TableColumn<AgendaMedico, String>("Especialidade");
	@FXML private TableColumn<AgendaMedico, String> clMedico = new TableColumn<AgendaMedico, String>("Nome");
	@FXML private TableColumn<AgendaMedico, String> clDia  = new TableColumn<AgendaMedico, String>("Dia");
	@FXML private TableColumn<AgendaMedico, String> clHorario  = new TableColumn<AgendaMedico, String>("Horário");
	@FXML private Button btVoltar;
	@FXML private TextField txEspecialidade, txMedico, txDia, txHorario;
	//@FXML private ComboBox<String> cbEspecialidade = new ComboBox<>();
	
	private List<String> especialidades = new ArrayList<String>();
	private ObservableList<String> obsEspecialidades;
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		initTable();
		//initComboBox();
				
	}
	
	/*public void initComboBox() {		
		especialidades.add("Cardiologia");
		especialidades.add("Ortopedia");
		obsEspecialidades = FXCollections.observableArrayList(especialidades);
		cbEspecialidade.setItems(obsEspecialidades);
	}*/
		
	public void initTable() {
		tbAgendaEspecialista.setItems(atualizaTabela());
		clEspecialidade.setCellValueFactory(new PropertyValueFactory<AgendaMedico, String>("especialidade"));
		clMedico.setCellValueFactory(new PropertyValueFactory<AgendaMedico, String>("nome"));
		clDia.setCellValueFactory(new PropertyValueFactory<AgendaMedico, String>("dia"));
		clHorario.setCellValueFactory(new PropertyValueFactory<AgendaMedico, String>("horario"));
		
		tbAgendaEspecialista.getColumns().setAll(clEspecialidade, clMedico, clDia, clHorario);
	}
	
	public ObservableList<AgendaMedico> atualizaTabela(){
		AgendaEspecialistaDao dao = new AgendaEspecialistaDao();
		return FXCollections.observableArrayList(dao.listarAgenda());
	}
	
	@FXML
	public AgendaMedico tbAgendaEspecialistaClicked(MouseEvent e) {
		int index = tbAgendaEspecialista.getSelectionModel().getSelectedIndex();
		AgendaMedico consultaSelecionada = (AgendaMedico)tbAgendaEspecialista.getItems().get(index);
		
		txEspecialidade.setText(consultaSelecionada.getEspecialidade());
		txMedico.setText(consultaSelecionada.getNome());
		txDia.setText(consultaSelecionada.getDia());
		txHorario.setText(consultaSelecionada.getHorario());
		
		return consultaSelecionada;
	}
	
	@FXML
	public void voltarPaciente()
	{		
		Parent root = null;
		Stage stage = (Stage) btVoltar.getScene().getWindow();
		FXMLLoader loader = new FXMLLoader();
		try {
			root = loader.load(getClass().getResource("../view/Paciente.fxml").openStream());	
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.setTitle("Tela do Paciente");
			stage.show();
		}catch (IOException e) {
			e.printStackTrace();
		}
	}

}
