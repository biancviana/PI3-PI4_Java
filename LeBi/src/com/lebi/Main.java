package com.lebi;
	
import com.lebi.model.BancoDeDados;
import com.lebi.gui.*;
import com.lebi.model.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = FXMLLoader.load(getClass().getResource("gui/principal.fxml"));
			Scene scene = new Scene(root,600,500);
			scene.getStylesheets().add(getClass().getResource("gui/application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		BancoDeDados bd = new BancoDeDados();
		bd.conectar();
		if(bd.estaConectado()) {
			bd.listarAgenda();
			bd.desconectar();
		} else {
			System.out.println("Não foi possível conectar ao banco de dados");
		}
		launch(args);
	}
}
