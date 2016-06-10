
/* Comp 2070-01/02
* Lab 3
* Due: 2/8/2016
* Kianush Aryan
* This program converts tempratures between C/F units and shows program control
*/
import java.util.Scanner;

public class Part2Problem4 {
	static Scanner keyboard = new Scanner(System.in);
	static String input;

	public static void main(String[] args) {
		System.out.println("Enter temperature in C/F");
		while (true) {
			input = keyboard.next();
			int length = input.length();
			char unit = (input.charAt(length - 1));
			String unprocessedValue = input.substring(0, length - 1);
			int value = Integer.valueOf(unprocessedValue);
			switch (unit) {
			case 'f':
			case 'F':
				convertFromFahrenheit(value);
				break;
			case 'c':
			case 'C':
				convertFromCelsius(value);
				break;
			case 'q':
			case 'Q':
				System.exit(0);
			default:
				System.out.println("Invlid Entry... Please Enter formatted data");
			}
		}

	}

	private static void convertFromCelsius(int value) {
		System.out.println("Fahrenheit: " + (value * 9 / 5 + 32));
		System.out.println("Enter Q or q to quit or any other key to repeat ");
	}

	private static void convertFromFahrenheit(int value) {
		System.out.println("Celsius: " + (value - 32) * 5 / 9);
		System.out.println("Enter Q or q to quit or any other key to repeat ");
	}

}
