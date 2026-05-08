package AssignmentDay1;
import java.util.Scanner;

public class P3_largest_of_two {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter first number: ");
		int num1 = sc.nextInt();
		System.out.print("Enter second number: ");
		int num2 = sc.nextInt();
		if(num1>num2) {
			System.out.println("First is Largest");
		}
		else {
			System.out.println("Second is largest");
		}
		sc.close();

	}

}
