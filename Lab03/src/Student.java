
public class Student {
	private static int nextStudentNumber = 1;
	private final int studentNumber;
	Student(){
		studentNumber = nextStudentNumber++;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student test = new Student();
		Student test1 = new Student();
		if('a' < 'b')
		System.out.println("works!");
		System.out.printf("%x", 'c');
	}

}
