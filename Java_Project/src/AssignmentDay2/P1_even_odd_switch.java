package AssignmentDay2;
import java.util.Scanner;

public class P1_even_odd_switch {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter a number: ");
		int num = sc.nextInt();
		
		switch(num%2)
		{
			case 0: System.out.println("Even"); 
				break;
			default: System.out.println("Odd"); 
				break;
		}
		sc.close();
	}

}
