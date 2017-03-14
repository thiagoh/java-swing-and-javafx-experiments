package com.thiagoh.comp228.lab04.ex02;

import java.awt.Color;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class MainWindowController implements Initializable {

	@FXML
	private TextField textFieldName;

	@FXML
	private ComboBox<String> comboboxLineColor;
	@FXML
	private ListView<String> listColorFill;

	@FXML
	public void handleSubmitButtonAction(ActionEvent e) {
		System.out.println(textFieldName.getText());
	}

	private static final List<String> colorsName = Arrays.asList("black", "yellow", "orange", "red", "blue", "green");
	private static final Color[] colors = new Color[] { Color.black, Color.yellow, Color.orange, Color.red, Color.blue,
			Color.green };

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		comboboxLineColor.setItems(FXCollections.observableArrayList(colorsName));

		listColorFill.setItems(FXCollections.observableArrayList(colorsName));
	}

}
