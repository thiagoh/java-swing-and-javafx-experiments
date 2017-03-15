package com.thiagoh.comp228.lab04.ex02;

import javafx.application.Application;

public class Driver {

	public static void main(String[] args) {
		try {

			Application.launch(MainWindow.class, args);

		} catch (Exception e) {

			e.printStackTrace();
		}
	}
}
