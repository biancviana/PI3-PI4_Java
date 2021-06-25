package com.lebi;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;

public class Main extends Application {
	
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = FXMLLoader.load(getClass().getResource("view/Login.fxml"));
			Scene scene = new Scene(root,600,500);
			scene.getStylesheets().add(getClass().getResource("view/application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("Tela de Login");
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
