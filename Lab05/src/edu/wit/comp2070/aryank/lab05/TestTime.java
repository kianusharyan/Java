/*
 * Kianush Aryan
 * Comp 2070-01
 * Lab 05 Problem 2
 * Due M 3/21/2016
 */
package edu.wit.comp2070.aryank.lab05;

import java.util.Scanner;

public class TestTime {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		while (true) {
			System.out.println("Enter the time in which format:\n1. 24 Hour \n2. 12 Hour \n3. Quit ");
			Scanner keyboard = new Scanner(System.in);
			int choice = keyboard.nextInt();
			Time time = new Time();
			switch (choice) {
			case 1:
				System.out.println("Enter the Hour");
				int hour = keyboard.nextInt();
				System.out.println("Enter the Minute");
				int minute = keyboard.nextInt();
				time.setTime(hour, minute);
				System.out.println("You have entered:\n" + hour + ":" + minute + "\n");
				break;
			case 2:
				System.out.println("Enter the Hour");
				int hours = keyboard.nextInt();
				System.out.println("Enter the Minute");
				int minutes = keyboard.nextInt();
				System.out.println("Enter pm or am");
				String amOrPm = keyboard.nextLine();
				if (amOrPm.equalsIgnoreCase("am")) {
					time.setTime(hours, minutes, true);
				}
				else{
					time.setTime(hours, minutes, false);
				}
				System.out.println("You have entered:\n" + hours + ":" + minutes + "\n" + amOrPm);
				break;
			case 3:
				System.out.println("goodbye");
				keyboard.close();
				System.exit(0);
			}
		}
	}

}
