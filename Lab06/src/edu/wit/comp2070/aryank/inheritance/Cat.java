/*
* Comp 2070-01/02
* Lab 6
* Due: 4/10/2016
* Kianush Aryan
*/
package edu.wit.comp2070.aryank.inheritance;

public class Cat extends Pet {

	Cat() {
		super();
	}

	/**
	 * 
	 * @param otherPet
	 * @return
	 */
	@Override
	public int compareTo(Pet otherPet) {
		if (this.equals(otherPet)) {
			return 0;
		} else {
			return this.getAge() - otherPet.getAge();
		}
	}

	/**
	 * 
	 */
	@Override
	public boolean equals(Object other) {
		Pet otherPet = (Pet) other;
		return this.getName().equals(otherPet.getName());
	}

	/**
	 * 
	 */
	@Override
	public String toString() {
		return "Pet '" + getName() + "' is " + getAge() + " year" + (getAge() == 1 ? "" : "s") + " old and weighs "
				+ getWeight() + " pound" + (getWeight() == 1.0 ? "" : "s") + ".";
	}

	@Override
	public String speak() {
		// TODO Auto-generated method stub
		return null;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

}
