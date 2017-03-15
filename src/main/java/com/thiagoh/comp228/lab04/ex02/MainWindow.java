package com.thiagoh.comp228.lab04.ex02;

import java.io.InputStream;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainWindow extends Application {

	@Override
	public void start(Stage stage) throws Exception {

		ClassLoader classLoader = MainWindow.class.getClassLoader();

		InputStream resource = classLoader.getResourceAsStream("main_window.fxml");

		if (resource == null) {
			throw new IllegalStateException("Could not find the window definition");
		}

		FXMLLoader fxmlLoader = new FXMLLoader();
		Parent root = fxmlLoader.load(resource);

		stage.setTitle("Shapes");
		stage.setScene(new Scene(root, 570, 360));
		stage.setResizable(false);
		stage.show();

	}

	@FXML
	public void handleSubmitButtonAction(ActionEvent e) {
		System.out.println("nhaaaaaaaaa");
	}

	public static void main(String[] args) {
		try {

			Application.launch(MainWindow.class, args);

		} catch (Exception e) {

			e.printStackTrace();
		}
	}
}
