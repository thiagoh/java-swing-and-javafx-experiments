package com.thiagoh.comp228.lab04.ex01;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractListModel;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

/**
 *
 * @author thiagoh
 */
public class MainWindow extends javax.swing.JFrame {

	private static final String[] colorsName = new String[] { "black", "yellow", "orange", "red", "blue", "green" };
	private static final Color[] colors = new Color[] { Color.black, Color.yellow, Color.orange, Color.red, Color.blue,
			Color.green };

	private ResponseWindow responseWindow;

	public MainWindow() {
		initProperties();
	}

	public void initProperties() {

		jLabel1 = new JLabel();
		jTextField1 = new JTextField();
		jLabel2 = new JLabel();
		jRadioButton1 = new JRadioButton();
		jRadioButton2 = new JRadioButton();
		jRadioButton3 = new JRadioButton();
		jLabel3 = new JLabel();
		jLabel4 = new JLabel();
		jLabel5 = new JLabel();
		jCheckBox1 = new JCheckBox();
		jCheckBox2 = new JCheckBox();
		jCheckBox3 = new JCheckBox();
		jComboBox1 = new JComboBox<>();
		jScrollPanelColorList = new JScrollPane();
		jList1 = new JList<>();
		jButton1 = new JButton();

		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		jLabel1.setText("Name:");

		jLabel2.setText("What shape to draw?");

		jRadioButton1.setSelected(true);
		jRadioButton1.setText("Rectangle");

		jRadioButton2.setText("Square");

		jRadioButton3.setText("Circle");

		jLabel3.setText("What to color?");

		jLabel4.setText("What color of line?");

		jLabel5.setText("What color of fill?");

		jCheckBox1.setSelected(true);
		jCheckBox1.setText("Fill");

		jCheckBox2.setSelected(true);
		jCheckBox2.setText("Background");

		jCheckBox3.setSelected(true);
		jCheckBox3.setText("Line");

		jComboBox1.setModel(new DefaultComboBoxModel<>(colorsName));

		jList1.setModel(new AbstractListModel<String>() {
			String[] strings = colorsName;

			public int getSize() {
				return strings.length;
			}

			public String getElementAt(int i) {
				return strings[i];
			}
		});
		jScrollPanelColorList.setViewportView(jList1);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridLayout gridLayout = new GridLayout(6, 2);
		setLayout(gridLayout);
		setPreferredSize(new Dimension(550, 360));

		add(jLabel1);
		add(jTextField1);

		add(jLabel2);

		// shapes type to draw - BEGIN
		{
			JPanel jShapesPanel = new JPanel(new GridLayout(1, 3));
			ButtonGroup group = new ButtonGroup();
			group.add(jRadioButton1);
			group.add(jRadioButton2);
			group.add(jRadioButton3);
			jShapesPanel.add(jRadioButton1);
			jShapesPanel.add(jRadioButton2);
			jShapesPanel.add(jRadioButton3);
			add(jShapesPanel);
		}
		// shapes type to draw - END

		add(jLabel3);

		// colors to draw - BEGIN
		{
			JPanel jColorPanel = new JPanel(new GridLayout(1, 3));
			jColorPanel.add(jCheckBox1);
			jColorPanel.add(jCheckBox2);
			jColorPanel.add(jCheckBox3);
			add(jColorPanel);
		}
		// colors to draw - END

		add(jLabel4);
		add(jComboBox1);

		add(jLabel5);
		add(jScrollPanelColorList);

		add(jButton1);

		jButton1.setText("Submit");
		jButton1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// JOptionPane.showMessageDialog(MainWindow.this, "yay!");

				try {

					if (responseWindow != null) {
						responseWindow.dispose();
					}

					responseWindow = new ResponseWindow(MainWindow.this);
					responseWindow.setVisible(true);

				} catch (Exception ex) {

					JOptionPane.showMessageDialog(MainWindow.this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
					ex.printStackTrace();
				}
			}
		});

		setTitle("Shapes");

		pack();
	}

	public String getUserName() {
		return jTextField1.getText();
	}

	public String getShapeType() {

		String shapeType = null;

		if (jRadioButton1.isSelected()) {
			shapeType = "rectangle";
		}

		if (jRadioButton2.isSelected()) {
			shapeType = "square";
		}

		if (jRadioButton3.isSelected()) {
			shapeType = "circle";
		}

		return shapeType;
	}

	public Color getOutlineColor() {
		int colorIndex = Math.max(0, jComboBox1.getSelectedIndex());
		return colors[colorIndex];
	}

	public Color getFillColor() {
		int colorIndex = Math.max(0, jList1.getSelectedIndex());
		return colors[colorIndex];
	}

	public Color getBacklColor() {
		return Color.white;
	}

	public boolean isShapeFilled() {
		return jCheckBox1.isSelected();
	}

	public boolean isShapeOutlined() {
		return jCheckBox3.isSelected();
	}

	public boolean isShapeBackColored() {
		return jCheckBox2.isSelected();
	}

	private JButton jButton1;
	private JCheckBox jCheckBox1;
	private JCheckBox jCheckBox2;
	private JCheckBox jCheckBox3;
	private JComboBox<String> jComboBox1;
	private JLabel jLabel1;
	private JLabel jLabel2;
	private JLabel jLabel3;
	private JLabel jLabel4;
	private JLabel jLabel5;
	private JList<String> jList1;
	private JRadioButton jRadioButton1;
	private JRadioButton jRadioButton2;
	private JRadioButton jRadioButton3;
	private JScrollPane jScrollPanelColorList;
	private JTextField jTextField1;

}
