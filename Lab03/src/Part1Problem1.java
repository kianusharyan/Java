
/*
* Comp 2070-01/02
* Lab 3
* Due: 2/8/2016
* Kianush Aryan
* This program encrypts Strings in Caesar's cipher algorithm.
* The user enters a string and the integer to shift by.
* 2/10/2016 Updated with professo'rs code review
*/

import java.util.Scanner;

public class Part1Problem1 {

	static char[] alphabetLowerCase = "abcdefghijklmnopqrstuvwxyz".toCharArray();
	static char[] alphabetUpperCase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();

	static void encrypt(String message, int shift) {

		for (int j = 0; j < message.length(); j++) {
			for (int i = 0; i < 26; i++) {
				if (alphabetLowerCase[i] == message.charAt(j)) {
					try {
						System.out.print("" + alphabetLowerCase[i + shift]);
					} catch (java.lang.ArrayIndexOutOfBoundsException e) {
						if (shift < 0) {
							System.out.print(alphabetLowerCase[alphabetLowerCase.length + shift]);
						} else {

							System.out.print(alphabetLowerCase[(i - alphabetLowerCase.length) + shift]);
						}
					}
				} else if (alphabetUpperCase[i] == message.charAt(j)) {
					try {
						System.out.print("" + alphabetUpperCase[i + shift]);
					} catch (java.lang.ArrayIndexOutOfBoundsException e) {
						if (shift < 0) {
							System.out.print(alphabetUpperCase[alphabetUpperCase.length + shift]);
						} else {
							System.out.print(alphabetUpperCase[i - alphabetUpperCase.length + shift]);
						}
					}
				}
			}
		}
	}

	static void encryptUpdated(String message, int shift) {
		for (int u = 0; u < message.length(); u++)
			for (int k = 0; k < 26; k++) {
				if (message.charAt(u) == 'a' + k) {
					int temp = message.charAt(u) + shift;
					if ((temp <= 122) && (temp >= 97)) {
						System.out.print((char) temp);
					} else if ((message.charAt(u) + shift) > 122) {
						int temp2 = (char) 'a' - 1 + shift;
						System.out.println((char) temp2);
					} else {
						int temp3 = (char) 'z' + 1 + shift;
						System.out.println((char) temp3);
					}

				}
			}
	}

	public static void main(String[] args) {

		Scanner keyboard = new Scanner(System.in);
		System.out.println("Enter the string to be encrypted");
		String message = keyboard.nextLine();
		System.out.println("Enter how many you want to shift");
		int shift = keyboard.nextInt();
		encryptUpdated(message, shift);
		keyboard.close();

	}

}
