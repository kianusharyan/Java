/*
* Comp 2070-01/02
* Lab 4
* Due: 2/30/2016
* Kianush Aryan
* Class Dog interface implementation
*/
public class Dog {
	private String name;
	private String breed;
	private int age;

	public void writeOutput() {
		System.out.println("Name: " + name);
		System.out.println("Breed: " + breed);
		System.out.println("Age in calendar years: " + age);
		System.out.println("Age in human years: " + getAgeInHumanYears());
		System.out.println();
	}

	public int getAgeInHumanYears() {
		int humanYears = 0;
		if (age <= 2) {
			humanYears = age * 11;
		} else {
			humanYears = 22 + ((age - 2) * 5);
		}
		return humanYears;
	}

	public boolean equals(Dog otherDog) {
		return ((0 ==this.name.compareToIgnoreCase(otherDog.name)) 
				&& (0 ==this.breed.compareToIgnoreCase(otherDog.breed))
				&& (otherDog.age == this.age));
	}

	public String getName() {
		return name;
	}

	public String getBreed() {
		return breed;
	}

	public int getAge() {
		return age;
	}

	public void setName(String newName) {
		name = newName;
	}

	public void setBreed(String newBreed) {
		breed = newBreed;
	}

	public void setAge(int newAge) {
		age = newAge;
	}

}
