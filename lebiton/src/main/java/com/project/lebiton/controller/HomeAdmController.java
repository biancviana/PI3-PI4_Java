package com.project.lebiton.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.project.lebiton.Main;

public class HomeAdmController implements Initializable{

	@FXML
	private Button btCadastrar;
	
	FXMLLoader root = null;
	
	@Override
	public void initialize(final URL arg0, final ResourceBundle arg1) {
	}
	
	@FXML
    public void cadastrarMedico(final ActionEvent actionEvent) {

        final Stage stage = (Stage) btCadastrar.getScene().getWindow();

        try {
            root = new FXMLLoader(HomeAdmController.class.getResource("/com/project/lebiton/view/CadastroMedico.fxml"));
            final Scene scene = new Scene(root.load());
            stage.setScene(scene);
            stage.setTitle("Cadastro Médico");
            stage.show();
        } catch (final IOException e) {
            e.printStackTrace();
        }
    }

}
