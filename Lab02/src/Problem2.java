import java.util.Scanner;

public class Problem2 {
	private static int quarters;
	private static int dimes;
	private static int nickels;
	private static int pennies;

	public static void getCoins(int totalCoins) {
		quarters = (totalCoins / 25);
		totalCoins %= 25;
		dimes = (totalCoins / 10);
		totalCoins %= 10;
		nickels = (totalCoins / 5);
		totalCoins %= 5;
		pennies = (totalCoins / 1);
		totalCoins %= 1;
	}

	public static void main(String[] args) {
		
		Scanner keyboard = new Scanner(System.in);
		String amount = keyboard.nextLine();
		String[] inputArr = amount.split("\\.");			//using a regular expression meta character "." to make the much needed split
		int leftOfDecimal = Integer.parseInt(inputArr[0]);			//the dynamic array holds the new data
		int rightOfDecimal = Integer.parseInt(inputArr[1]);
		getCoins(rightOfDecimal+(leftOfDecimal*100));
		keyboard.close();
		System.out.println("Quarters: " + quarters + "\nDimes: " + dimes + "\nNickels: " + nickels + "\nPennies: " + pennies);
		
	}
}
