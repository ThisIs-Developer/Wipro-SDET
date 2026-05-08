package ScannerClass;
import java.util.*;

public class Test {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter you name: ");
		String name = sc.nextLine();
		System.out.println("Hi "+name);
		sc.close();
	}
}
