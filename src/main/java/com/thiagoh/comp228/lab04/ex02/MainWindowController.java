package com.thiagoh.comp228.lab04.ex02;

import java.awt.Color;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class MainWindowController implements Initializable {

	private Stage responseWindow;

	@FXML
	private RadioButton radioShapeRectangle;
	@FXML
	private RadioButton radioShapeCircle;
	@FXML
	private RadioButton radioShapeSquare;

	@FXML
	private CheckBox checkboxColorBackground;
	@FXML
	private CheckBox checkboxColorFill;
	@FXML
	private CheckBox checkboxColorLine;

	@FXML
	private TextField textFieldName;

	@FXML
	private ComboBox<String> comboboxLineColor;

	@FXML
	private ListView<String> listColorFill;

	@FXML
	public void handleSubmitButtonAction(ActionEvent e) {

		try {

			ClassLoader classloader = MainWindowController.class.getClassLoader();

			InputStream resource = classloader.getResourceAsStream("response_window.fxml");

			if (resource == null) {
				throw new IllegalStateException("Could not find the window definition");
			}

			FXMLLoader fxmlLoader = new FXMLLoader();
			fxmlLoader.setController(new ResponseWindowController(this));

			Parent root = fxmlLoader.load(resource);

			if (responseWindow != null) {
				responseWindow.close();
			}

			responseWindow = new Stage();

			responseWindow.setTitle("Result");
			responseWindow.setScene(new Scene(root, 360, 550));
			responseWindow.setResizable(false);
			responseWindow.show();

		} catch (IOException ex) {

			Throwable cause = ex;

			if (ex.getCause() != null) {
				cause = ex.getCause();
			}

			Alert alert = new Alert(AlertType.ERROR, cause.getMessage());
			alert.showAndWait();

			ex.printStackTrace();
		}
	}

	private static final List<String> colorsName = Arrays.asList("black", "yellow", "orange", "red", "blue", "green");
	private static final Color[] colors = new Color[] { Color.black, Color.yellow, Color.orange, Color.red, Color.blue,
			Color.green };

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		comboboxLineColor.setItems(FXCollections.observableArrayList(colorsName));

		listColorFill.setItems(FXCollections.observableArrayList(colorsName));
	}

	public String getUserName() {
		return textFieldName.getText();
	}

	public String getShapeType() {

		String shapeType = null;

		if (radioShapeRectangle.isSelected()) {
			shapeType = "rectangle";
		}

		if (radioShapeSquare.isSelected()) {
			shapeType = "square";
		}

		if (radioShapeCircle.isSelected()) {
			shapeType = "circle";
		}

		return shapeType;
	}

	public Color getOutlineColor() {
		int colorIndex = Math.max(0, comboboxLineColor.getSelectionModel().getSelectedIndex());
		return colors[colorIndex];
	}

	public Color getFillColor() {
		int colorIndex = Math.max(0, listColorFill.getSelectionModel().getSelectedIndex());
		return colors[colorIndex];
	}

	public Color getBacklColor() {
		return Color.white;
	}

	public boolean isShapeFilled() {
		return checkboxColorFill.isSelected();
	}

	public boolean isShapeOutlined() {
		return checkboxColorLine.isSelected();
	}

	public boolean isShapeBackColored() {
		return checkboxColorBackground.isSelected();
	}

}
