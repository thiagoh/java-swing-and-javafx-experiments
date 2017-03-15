package com.thiagoh.comp228.lab04.ex02;

import java.awt.Color;
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
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author thiagoh
 */
public class ResponseWindowController implements Initializable {

	@FXML
	private AnchorPane anchorPaneMiddle;

	private MainWindowController main;
	private Shape jPanelShape = null;

	public ResponseWindowController(MainWindowController main) {
		this.main = main;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		String userName = GetterUtil.getString(main.getUserName());

		if (userName.trim().isEmpty()) {
			throw new IllegalStateException("Name cannot be empty");
		}

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

		SwingNode node = new SwingNode();
		node.setContent(jPanelShape);
		anchorPaneMiddle.getChildren().add(node);
	}

}