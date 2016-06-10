/*
* Comp 2070-01/02
* Lab 3
* Due: 2/8/2016
* Kianush Aryan
* Description: This program cracks encrypted strings by Caesar's cypher algorithm.
* The user enters a string and is provided with a table of possible combinations.
*/
import java.util.Scanner;


public class Part1Problem2 extends Part1Problem1 {
	static int shiftBy;

	static void decrypt(String jibberish) {
		for (shiftBy = 1; shiftBy <= 25; shiftBy++) { // shift possibilities
														// loop
			System.out.print("Shift by " + shiftBy + ": ");
			for (int j = 0; j < jibberish.length(); j++) { // word length loop
				for (int i = 0; i <= 25; i++) { // alphabet loop

					if (alphabetLowerCase[i] == jibberish.charAt(j)) {
						try {
							System.out.print("" + alphabetLowerCase[(i - shiftBy)]);
						} catch (java.lang.ArrayIndexOutOfBoundsException e) {

							System.out.print(alphabetLowerCase[alphabetLowerCase.length + (i - shiftBy)]);
						}
					} else if (alphabetUpperCase[i] == jibberish.charAt(j)) {
						try {
							System.out.print("" + alphabetUpperCase[(i - shiftBy)]);
						} catch (java.lang.ArrayIndexOutOfBoundsException e) {

							System.out.print(alphabetUpperCase[alphabetUpperCase.length + (i - shiftBy)]);
						}
					}
				}

			}
			System.out.println("");
		}

	}

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Enter the string to be decrypted");
		String message = keyboard.nextLine();
		System.out.println("Loading Please wait - Here are some possibilities...");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		decrypt(message);

	}

}
