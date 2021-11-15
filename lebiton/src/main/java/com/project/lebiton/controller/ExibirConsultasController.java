package com.project.lebiton.controller;

import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;

public class ExibirConsultasController implements Initializable {


    @FXML
    private Button btVoltar;
    @FXML
    private TableColumn<?, ?> clMedico;
    @FXML
    private TableColumn<?, ?> clPaciente;
    @FXML
    private TableColumn<?, ?> clHorario;
    @FXML
    private TableColumn<?, ?> clDia;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
