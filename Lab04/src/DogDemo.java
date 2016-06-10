/*
* Comp 2070-01/02
* Lab 4
* Due: 2/30/2016
* Kianush Aryan
* Demo Implementation of Dog interface
*/
public class DogDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Dog test = new Dog();
		test.setName("Scoob");
		test.setBreed("Great Dane");
		Dog test2 = new Dog();
		test2.setName("Scoob");
		// int t = test.getAge() == test2.getAge() && ?);
		System.out.println(test.equals(test2));
		// test.writeOutput();
	}

}
