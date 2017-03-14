package com.thiagoh.comp228.lab04.util;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 
 * @author Thiago Andrade Util class for input and output
 */
public class InOutUtil {

	public static String read(String message, String... acceptedValues) {

		Scanner s = new Scanner(System.in);
		System.out.println(message);
		String value = s.nextLine();

		if (acceptedValues != null && acceptedValues.length > 0) {

			while (!exists(acceptedValues, value)) {
				System.out.println("Invalid value! Please insert one of the following values: "
						+ String.join(",", acceptedValues));

				System.out.println(message);
				value = s.nextLine();
			}
		} else {

			while (value == null || value.trim().equals("")) {
				System.out.println("Null value! Please inform some value.");

				System.out.println(message);
				value = s.nextLine();
			}
		}

		return value;
	}

	public static boolean exists(String[] values, String search) {
		return Arrays.asList(values).contains(search);
	}
}
