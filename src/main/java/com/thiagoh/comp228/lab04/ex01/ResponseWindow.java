package com.thiagoh.comp228.lab04.ex01;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import com.thiagoh.comp228.lab04.util.GetterUtil;

/**
 *
 * @author thiagoh
 */
public class ResponseWindow extends javax.swing.JFrame {

	private MainWindow main;
	private Shape jPanelShape = null;
	private JPanel jPanelDescription = null;

	public ResponseWindow(MainWindow main) {

		this.main = main;

		initProperties();
	}

	public void initProperties() {

		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

		BorderLayout layoutManager = new BorderLayout();

		setLayout(layoutManager);
		setPreferredSize(new Dimension(360, 550));

		String userName = GetterUtil.getString(main.getUserName());

		if (userName.trim().isEmpty()) {
			throw new IllegalStateException("Name cannot be empty");
		}

		jLabel1 = new JLabel(userName);

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

		jPanelDescription = new JPanel(new GridLayout(1, 1));
		JTextArea jTextDescription = new JTextArea();
		JScrollPane jScrollPaneDescription = new JScrollPane(jTextDescription);
		jScrollPaneDescription.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		jTextDescription.setEditable(true);
		jTextDescription.setRows(10);

		StringBuilder description = new StringBuilder();

		description.append("fillCollor=").append(fillColor.toString());
		description.append("\nbackCollor=").append(backlColor.toString());
		description.append("\nlineCollor=").append(outlineColor.toString());
		description.append("\nisFilled=").append(isFilled ? "true" : "false");
		description.append("\nisOutlined=").append(isOutlined ? "true" : "false");
		description.append("\nisBackColored=").append(isBackColored ? "true" : "false");

		jTextDescription.setText(description.toString());

		{
			Dimension dimension = new Dimension(jPanelDescription.getWidth(), 140);

			jPanelDescription.setPreferredSize(dimension);
			jPanelDescription.setSize(dimension);
		}

		jPanelDescription.add(jScrollPaneDescription);

		{
			Dimension dimension = new Dimension(jLabel1.getWidth(), 40);

			jLabel1.setPreferredSize(dimension);
			jLabel1.setSize(dimension);
		}

		add(jLabel1, BorderLayout.PAGE_START);
		add(jPanelShape, BorderLayout.CENTER);
		add(jPanelDescription, BorderLayout.PAGE_END);

		setTitle("Result");

		pack();
	}

	@Override
	public void paintComponents(Graphics g) {
		super.paintComponents(g);

		jPanelShape.paintComponent(g);
	}

	private JLabel jLabel1;

}
