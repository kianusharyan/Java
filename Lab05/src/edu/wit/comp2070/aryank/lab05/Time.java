/*
 * Kianush Aryan
 * Comp 2070-01
 * Lab 05 Problem 1
 * Due M 3/21/2016
 */

package edu.wit.comp2070.aryank.lab05;

public class Time {
	private int hours;
	private int minutes;

	/**
	 * This initializes the time to 0 hours, 0 minutes whenever object is
	 * created.
	 */
	public Time() {
		this.hours = 0;
		this.minutes = 0;
	}

	/**
	 * Creates and initializes a Time object given the time in 24-hour format
	 * 
	 * @param initialHours
	 *            24-hour format in the range 0..23
	 * @param initialMinutes
	 *            minutes in the range 0..59
	 *            <p>
	 *            postconditions: if the specified hours and minutes are
	 *            in-range, the object will reflect those value however, the
	 *            time will be set to 0 hours and 0 minutes (12:00 midnight) if
	 *            either or both values are out-of-range
	 */
	public Time(int initialHours, int initialMinutes) {
		// TODO: implement this
		setTime(initialHours, initialMinutes);
	}

	/**
	 * 
	 * @param initialHours
	 * @param initialMinutes
	 * @param isAM
	 */
	public Time(int initialHours, int initialMinutes, boolean isAM) {
		setTime(initialHours, initialMinutes, isAM);
	}

	public String getTime12() {
		String response;
		if (this.hours < 12 && this.hours >= 0) {
			return this.hours + ":" + this.minutes + " am";
		} else {
			return response = this.hours + ":" + this.minutes + " pm";
		}

	}

	public String getTime24() {
		String response = this.hours + "" + this.minutes;
		return response;
	}

	public void setTime(int newHours, int newMinutes) {
		if (isValid(newHours, newMinutes)) {
			this.hours = newHours;
			this.minutes = newMinutes;
		}
	}

	public void setTime(int newHours, int newMinutes, boolean isAM) {
		if (newHours > 0 && newHours < 12)
			this.hours = newHours;
		if (newMinutes > 0 && newMinutes < 60)
			this.minutes = newMinutes;

	}

	@Override
	public String toString() {
		return String.format("(%d, %d)", hours, minutes);
	}

	private boolean isValid(int timeHours, int timeMinutes) {
		// TODO: implement this
		if ((timeHours < 24 && timeMinutes >= 0) && (timeHours >= 0 && timeMinutes < 60)) {
			return true;
		}
		return false; // placeholder: return a meaningful value

	}

	public static void main(String[] args) {
		final boolean AM = true;
		final boolean PM = false;

		final boolean VALID_TEST = true;
		final boolean ERROR_TEST = false;

		Time testTime;

		testTime = new Time();
		displayTest(VALID_TEST, "new Time()", testTime, "(0, 0)", "0000", "12:00 am");

		testTime = new Time(0, 0);
		displayTest(VALID_TEST, "new Time( 0, 0 )", testTime, "(0, 0)", "0000", "12:00 am");

		testTime = new Time(-1, 1);
		displayTest(ERROR_TEST, "new Time( -1, 1 )", testTime, "(0, 0)", "0000", "12:00 am");

		testTime = new Time(1, -1);
		displayTest(ERROR_TEST, "new Time( 1, -1 )", testTime, "(0, 0)", "0000", "12:00 am");

		testTime = new Time(24, 1);
		displayTest(ERROR_TEST, "new Time( 24, 1 )", testTime, "(0, 0)", "0000", "12:00 am");

		testTime = new Time(1, 60);
		displayTest(ERROR_TEST, "new Time( 1, 60 )", testTime, "(0, 0)", "0000", "12:00 am");

		testTime = new Time(0, 19);
		displayTest(VALID_TEST, "new Time( 0, 19 )", testTime, "(0, 19)", "0019", "12:19 am");

		testTime = new Time(3, 5);
		displayTest(VALID_TEST, "new Time( 3, 5 )", testTime, "(3, 5)", "0305", "3:05 am");

		testTime = new Time(12, 1);
		displayTest(VALID_TEST, "new Time( 12, 1 )", testTime, "(12, 1)", "1201", "12:01 pm");

		testTime = new Time(12, 1, AM);
		displayTest(VALID_TEST, "new Time( 12, 1, AM )", testTime, "(0, 1)", "0001", "12:01 am");

		testTime = new Time(12, 1, PM);
		displayTest(VALID_TEST, "new Time( 12, 1, PM )", testTime, "(12, 1)", "1201", "12:01 pm");

		testTime = new Time(3, 45, AM);
		displayTest(VALID_TEST, "new Time( 3, 45, AM )", testTime, "(3, 45)", "0345", "3:45 am");

		testTime = new Time(3, 45, PM);
		displayTest(VALID_TEST, "new Time( 3, 45, PM )", testTime, "(15, 45)", "1545", "3:45 pm");

		testTime = new Time(3, 45);
		displayTest(VALID_TEST, "new Time( 3, 45 )", testTime, "(3, 45)", "0345", "3:45 am");

		testTime = new Time(15, 45);
		displayTest(VALID_TEST, "new Time( 15, 45 )", testTime, "(15, 45)", "1545", "3:45 pm");

		testTime.setTime(12, 21);
		displayTest(VALID_TEST, "setTime( 12, 21 )", testTime, "(12, 21)", "1221", "12:21 pm");

		testTime.setTime(-1, 13);
		displayTest(ERROR_TEST, "setTime( -1, 13 )", testTime, "(12, 21)", "1221", "12:21 pm");

		testTime.setTime(13, -1);
		displayTest(ERROR_TEST, "setTime( 13, -1 )", testTime, "(12, 21)", "1221", "12:21 pm");

		testTime.setTime(24, 42);
		displayTest(ERROR_TEST, "setTime( 24, 42 )", testTime, "(12, 21)", "1221", "12:21 pm");

		testTime.setTime(6, 60);
		displayTest(ERROR_TEST, "setTime( 6, 60 )", testTime, "(12, 21)", "1221", "12:21 pm");

		testTime.setTime(8, 16, AM);
		displayTest(VALID_TEST, "setTime( 8, 16, AM )", testTime, "(8, 16)", "0816", "8:16 am");

		testTime.setTime(9, 17, PM);
		displayTest(VALID_TEST, "setTime( 9, 17, PM )", testTime, "(21, 17)", "2117", "9:17 pm");

		testTime.setTime(0, 15, AM);
		displayTest(ERROR_TEST, "setTime( 0, 15, AM )", testTime, "(21, 17)", "2117", "9:17 pm");

		testTime.setTime(13, 14, AM);
		displayTest(ERROR_TEST, "setTime( 13, 14, AM )", testTime, "(21, 17)", "2117", "9:17 pm");

		testTime.setTime(0, 13, PM);
		displayTest(ERROR_TEST, "setTime( 0, 13, PM )", testTime, "(21, 17)", "2117", "9:17 pm");

		testTime.setTime(13, 12, PM);
		displayTest(ERROR_TEST, "setTime( 13, 12, PM )", testTime, "(21, 17)", "2117", "9:17 pm");

		testTime.setTime(12, 19, AM);
		displayTest(VALID_TEST, "setTime( 12, 19, AM )", testTime, "(0, 19)", "0019", "12:19 am");

		testTime.setTime(11, 14, PM);
		displayTest(VALID_TEST, "setTime( 11, 14, PM )", testTime, "(23, 14)", "2314", "11:14 pm");

		testTime.setTime(11, 59, AM);
		displayTest(VALID_TEST, "setTime( 11, 59, AM )", testTime, "(11, 59)", "1159", "11:59 am");

		testTime.setTime(11, 59, PM);
		displayTest(VALID_TEST, "setTime( 11, 59, PM )", testTime, "(23, 59)", "2359", "11:59 pm");

	}

	private static void displayTest(boolean isValid, String testDescription, Time testTime, String expectedRawTime,
			String expected24HourTime, String expected12HourTime) {
		System.out.println((isValid ? "Valid" : "Error") + " test: " + testDescription);
		displayTestExpected(expectedRawTime, expected24HourTime, expected12HourTime);
		displayTestActual(testTime);
		System.out.println();
	}

	private static void displayTestActual(Time testTime) {
		System.out.printf("Actual:\t%10s\t%s\t%s\n", testTime, testTime.getTime24(), testTime.getTime12());
	}

	private static void displayTestExpected(String expectedRawTime, String expected24HourTime,
			String expected12HourTime) {
		System.out.printf("Expect:\t%10s\t%s\t%s\n", expectedRawTime, expected24HourTime, expected12HourTime);
	}

}
