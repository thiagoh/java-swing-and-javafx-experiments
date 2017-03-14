package com.thiagoh.comp228.lab04.util;

public class GetterUtil {

	public static double getDouble(String value) {

		if (value == null || value.trim().equals("")) {
			return 0.0;
		}

		try {

			return Double.parseDouble(value);

		} catch (NumberFormatException e) {
			return 0.0;
		}
	}

	public static int getInt(String value) {
		if (value == null || value.trim().equals("")) {
			return 0;
		}

		try {

			return Integer.parseInt(value);

		} catch (NumberFormatException e) {
			return 0;
		}
	}

	public static String getString(String userName) {

		if (userName == null) {
			return "";
		}

		return userName;
	}
}
