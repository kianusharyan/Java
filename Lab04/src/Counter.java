/*
* Comp 2070-01/02
* Lab 4
* Due: 2/30/2016
* Kianush Aryan
* Class Counter interface implementation .
* An object of this class is used to count things, 
* so it records a count that is a nonnegative whole number
*/

public class Counter {
	private int count;

	public Counter() {
		count = 0;
	}

	public void reset() {
		count = 0;
	}

	public void increase() {
		count++;
	}

	public void decrease() {
		if (count >= 1) {
			count--;
		}
	}

	public int getCount() {
		return count;
	}

	public void displayCount() {
		System.out.println("The value of count: " + count);
	}
}
