class A{
	public A(){
		System.out.println("A");
	}
}
class B extends A {
	public B(){
		System.out.println("B");
	}
}
public class Testing {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			A b = new B();
	}

}
