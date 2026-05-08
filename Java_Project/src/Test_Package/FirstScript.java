package Test_Package;

public class FirstScript {
	void Cat() {
		System.out.println("Cat Calling");
	}
	
	public static void main(String[] args) {
		System.out.println("Hello Bachoo");
		System.out.println("Hello Wipro");
		FirstScript fs = new FirstScript();
		fs.Cat();
	}
}
