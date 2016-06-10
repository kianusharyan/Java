package edu.wit.comp2070.aryank.inheritance;

public class TalkativeTurtle extends Pet {

	private boolean hasEnergy;

	public TalkativeTurtle(){
		super();
		
	}
	@Override
	public String speak() {
		// TODO Auto-generated method stub
		return "Hello";
	}
	
	public void swim() {
		if(hasEnergy)
			System.out.println("I am swimming!");
			hasEnergy = false;
		
		System.out.println("I don't have enough Energy");
	}
	
	public static void Main(String[] args){
		TalkativeTurtle mypet = new TalkativeTurtle();
		mypet.speak();
		mypet.swim();
		mypet.swim();
	}
	

}
