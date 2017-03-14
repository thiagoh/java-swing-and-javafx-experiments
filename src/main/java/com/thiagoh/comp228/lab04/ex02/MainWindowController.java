package com.thiagoh.comp228.lab04.ex02;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class MainWindowController {

	@FXML
	private TextField textFieldName;

	@FXML
	public void handleSubmitButtonAction(ActionEvent e) {
		System.out.println(textFieldName.getText());
	}

}
