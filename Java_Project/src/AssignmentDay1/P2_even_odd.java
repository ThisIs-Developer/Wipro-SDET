package AssignmentDay1;
import java.util.Scanner;

public class P2_even_odd {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter a number: ");
		int num = sc.nextInt();
		if(num%2==0) {
			System.out.println("EVen Number");
		}
		else {
			System.out.println("Odd Number");
		}
		sc.close();

	}

}
