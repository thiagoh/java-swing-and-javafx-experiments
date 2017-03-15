package com.thiagoh.comp228.lab04.ex02;

import java.awt.Color;
import java.awt.Dimension;
import java.net.URL;
import java.util.ResourceBundle;

import com.thiagoh.comp228.lab04.ex01.Circle;
import com.thiagoh.comp228.lab04.ex01.Rectangle;
import com.thiagoh.comp228.lab04.ex01.Shape;
import com.thiagoh.comp228.lab04.ex01.Square;
import com.thiagoh.comp228.lab04.util.GetterUtil;

import javafx.embed.swing.SwingNode;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;

/**
 *
 * @author thiagoh
 */
public class ResponseWindowController implements Initializable {

	@FXML
	private Label labelName;

	@FXML
	private TextArea textAreaDescription;

	@FXML
	private AnchorPane anchorPaneMiddle;

	private MainWindowController main;
	private Shape jPanelShape = null;

	public ResponseWindowController(MainWindowController mainWindowController) {
		this.main = mainWindowController;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		String userName = GetterUtil.getString(main.getUserName());

		if (userName.trim().isEmpty()) {
			throw new IllegalStateException("Name cannot be empty");
		}

		labelName.setText(userName);

		String shapeType = GetterUtil.getString(main.getShapeType()).toLowerCase();

		Color outlineColor = main.getOutlineColor();
		Color fillColor = main.getFillColor();
		Color backlColor = main.getBacklColor();
		boolean isFilled = main.isShapeFilled();
		boolean isOutlined = main.isShapeOutlined();
		boolean isBackColored = main.isShapeBackColored();

		if ("rectangle".equals(shapeType)) {
			jPanelShape = new Rectangle(outlineColor, fillColor, backlColor, isFilled, isOutlined, isBackColored);

		} else if ("square".equals(shapeType)) {
			jPanelShape = new Square(outlineColor, fillColor, backlColor, isFilled, isOutlined, isBackColored);

		} else if ("circle".equals(shapeType)) {
			jPanelShape = new Circle(outlineColor, fillColor, backlColor, isFilled, isOutlined, isBackColored);
		} else {
			throw new IllegalStateException("No such shape");
		}

		StringBuilder description = new StringBuilder();

		description.append("fillCollor=").append(fillColor.toString());
		description.append("\nbackCollor=").append(backlColor.toString());
		description.append("\nlineCollor=").append(outlineColor.toString());
		description.append("\nisFilled=").append(isFilled ? "true" : "false");
		description.append("\nisOutlined=").append(isOutlined ? "true" : "false");
		description.append("\nisBackColored=").append(isBackColored ? "true" : "false");

		textAreaDescription.setText(description.toString());

		SwingNode node = new SwingNode();

		Dimension dimension = new Dimension(550, 300);
		jPanelShape.setSize(dimension);
		jPanelShape.setPreferredSize(dimension);

		anchorPaneMiddle.getChildren().add(node);
		anchorPaneMiddle.setPrefHeight(dimension.getHeight());
		anchorPaneMiddle.setPrefWidth(dimension.getWidth());
		// anchorPaneMiddle.setBackground(new Background(
		// new BackgroundFill(javafx.scene.paint.Color.rgb(17, 119, 255),
		// CornerRadii.EMPTY, Insets.EMPTY)));

		node.setContent(jPanelShape);
	}

}
