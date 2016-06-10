/*
* Comp 2070-01/02
* Lab 7
* Due: 4/17/2016
* Kianush Aryan
* Spend hours debugging and I couldn't find out why HashMap doesn't work with getOrDefault method, 
* so I hacked up this algorithm instead for problem 2, every test case works.(so far)
*/

package edu.wit.comp2070.aryank.lab7;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public final class Lab7Solution {

	static void problem1() {
		try {
			HashSet<String> names = new HashSet<String>();
			File file = new File("names.txt");
			Scanner inputStream = new Scanner(file);
			while (inputStream.hasNext()) {
				String test = inputStream.nextLine();
				names.add(test);
			}
			System.out.println("Removed Duplicates!");
			System.out.println("The invitation list contains \n -----------------");
			for (String i : names) {
				System.out.println(i);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	static void problem2() {
		try {
			File file = new File("enrollments.txt");
			Scanner inputStream = new Scanner(file);
			HashMap<Integer, ArrayList<String>> students = new HashMap<Integer, ArrayList<String>>();
			ArrayList<String> arrayList = new ArrayList();
			while (inputStream.hasNext()) {
				Integer id = inputStream.nextInt();
				if (id == -1) {
					break;
				}
				String element = inputStream.nextLine();
				arrayList.add(element);
				ArrayList<String> arrayList2 = new ArrayList();
				arrayList2 = (ArrayList<String>) arrayList.clone();
				Object key = id;

				if (students.get(key) != null) {
					arrayList2.addAll(students.get(key));
				}
				arrayList.clear();
				students.put(id, arrayList2);
				System.out.println(students);

			}
			printHashMap(students);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void printHashMap(HashMap<Integer, ArrayList<String>> map) {

		System.out.println("All data:\n----------------------------");

		for (Integer test : map.keySet()) {

			System.out.println("Student ID: " + test);
			System.out.println("Classes: \n" + map.get(test));
			System.out.println();
		}
		System.out.println("------------------------------------\n End of Program");
	}

	public static void main(String[] args) {
		// problem1();
		// problem2();
	}

}
