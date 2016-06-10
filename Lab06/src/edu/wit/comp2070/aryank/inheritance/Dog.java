/*
* Comp 2070-01/02
* Lab 6
* Due: 4/10/2016
* Kianush Aryan
*/
package edu.wit.comp2070.aryank.inheritance;

/**
 * @author David M Rosenberg
 * 
 */
public class Dog extends Pet implements Comparable<Pet> {
	private boolean doesTricks;
	private boolean lazy;

	/**
	 * The default value for laziness is true if the dog does not do tricks, but
	 * it is modular in the other constructors
	 */
	public Dog() {
		super();
		setLazy(false);
		setDoesTricks(false);
	}

	/**
	 * @param initialName
	 *            any non-null text, excluding the empty string
	 * @param initialAge
	 *            any non-negative number of years
	 * @param initialWeight
	 *            any non-negative number of pounds
	 * @throws ParameterOutOfRangeException
	 */
	public Dog(String initialName, int initialAge, double initialWeight) throws ParameterOutOfRangeException {
		this();

		setPet(initialName, initialAge, initialWeight);
	}

	/**
	 * @param initialName
	 *            any non-null text, excluding the empty string
	 * @param initialAge
	 *            any non-negative number of years
	 * @param initialWeight
	 *            any non-negative number of pounds
	 * @param initialDoesTricks
	 *            any true or false value depending on the dogs athletic ability
	 * @param initialisLazy
	 *            any true or false value depending on the dogs activity
	 * @throws ParameterOutOfRangeException
	 */
	public Dog(String initialName, int initialAge, double initialWeight, boolean initialDoesTricks,
			boolean initialisLazy) throws ParameterOutOfRangeException {
		this();

		setPet(initialName, initialAge, initialWeight);

		setDoesTricks(initialDoesTricks);
		setLazy(initialisLazy);
	}

	/**
	 * @return the doesTricks
	 */
	public boolean getDoesTricks() {
		return doesTricks;
	}

	/**
	 * @param doesTricks
	 *            the doesTricks to set whether the Dog performs any fun tricks
	 */
	public void setDoesTricks(boolean doesTricks) {
		this.doesTricks = doesTricks;
	}

	/**
	 * @return the isLazy
	 */
	public boolean isLazy() {

		return lazy;
	}

	/**
	 * @param isLazy
	 *            the isLazy to set whether the Dog is a couch potato
	 */
	public void setLazy(boolean isLazy) {
		this.lazy = isLazy;
	}

	/**
	 * 
	 * @param otherPet
	 * @return
	 */
	@Override
	public int compareTo(Pet otherPet) throws IllegalArgumentException {
		if (otherPet instanceof Dog) {
			Dog otherDog = (Dog) otherPet;
			if (this.equals(otherDog)) {
				return 0;
			} else {
				if (super.equals(otherDog)) {
					return (this.doesTricks ? 1 : -1);
					
				} else {
					return super.compareTo(otherDog);
				}
			}
		} else {
			throw new IllegalArgumentException("cant compare cat to dog");
		}

	}

	/**
	 * 
	 */
	@Override
	public boolean equals(Object other) {
		Dog otherDog = (Dog) other;
		return super.equals(otherDog) && (this.doesTricks == otherDog.doesTricks) && (this.lazy == otherDog.lazy);
	}

	@Override
	public String toString() {
		return "Pet '" + super.getName() + "' is " + super.getAge() + " year" + (super.getAge() == 1 ? "" : "s")
				+ " old and weighs " + super.getWeight() + " pound" + (super.getWeight() == 1.0 ? "" : "s") + "."
				+ " Does " + (this.getDoesTricks() == true ? "tricks" : "not do tricks") + ", it is "
				+ (this.isLazy() == true ? "lazy" : "not lazy");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.wit.comp2070.rosenbergd.inheritance.Pet#speak()
	 */
	@Override
	public String speak() {
		return this.getName() + " says: \"woof!\"";
	}

	public void Fetch(String itemFetched) {
		System.out.println(this.getName() + " has fetched a" + itemFetched);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Dog fido = new Dog("Fido", 3, 5.7, true, false);

			// WITHTRY
			// CATCH???----------------------------------------------------------------QUESTION
			// FOR PROFESSOR

			// test speak()
			System.out.println("Testing speak: ");
			try {
				System.out.println(fido.speak());
			} catch (NullPointerException e) {
				System.out.println("speak() caused exception: " + e.getMessage());
			}

			// test toString
			System.out.println("Testing toString:");
			try {
				System.out.println(fido.toString());
			} catch (NullPointerException e) {
				System.out.println("toString caused exception");
			}
			// test compareTo
			System.out.println("testing compareTo:");
			try {
				Pet tempPet = new Dog("Fido", 3, 5.7, true, false);
				System.out.println("function return value"+ fido.compareTo(tempPet));

			} catch (IllegalArgumentException e) {
				System.out.println("compareTo(otherPet) caused exception");
			}
			// test equals
			System.out.println("Testing equals:");
			try {
				Dog spot = new Dog("Spot", 3, 5.7, true, true);
				fido = spot;
				if (fido.equals(spot)) {
					System.out.println("(fido.equals(spot)) is true because they refererence the same object");
				}
			} catch (IllegalArgumentException e) {
				System.out.println("toString caused exception");
			}

			// WITHOUT TRY
			// CATCH???----------------------------------------------------------------QUESTION
			// FOR PROFESSOR
			// test is lazy
			System.out.println("Testing Lazy:");
			fido.setLazy(true);
			System.out.println("Dog is " + (fido.isLazy() == true ? "lazy" : "not lazy"));

			// test fetch
			fido.Fetch("shoe");

		} catch (

		ParameterOutOfRangeException e1)

		{
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

}
