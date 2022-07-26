package utils;

import java.util.Random;

public class GeneratePassword {
	public static String generatePassword() {
		int length = 15;
		String symbol = "-/.^&*_!@%=+>)";
		String cap_letter = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String small_letter = "abcdefghijklmnopqrstuvwxyz";
		String numbers = "0123456789";

		String finalString = cap_letter + small_letter + numbers + symbol;

		Random random = new Random();

		String pass = "";

		for (int i = 0; i < length; i++) {
			pass += finalString.charAt(random.nextInt(finalString.length()));
		}
		
		return pass;

	}
}
