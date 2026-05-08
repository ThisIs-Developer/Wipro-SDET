package Object_Class_Method;

public class Constructor {
	// Constructor
	// Constructor OverLoading;
	
	Constructor(){
		System.out.println("Hello bro");
	}
	Constructor(int age){
		System.out.println(age);
	}
	Constructor(int age, int salary){
		System.out.println(age+","+salary);
	}
	public static void main(String[] args) {
		new Constructor();
		new Constructor(23);
		new Constructor(23,4353466);
	}
}
