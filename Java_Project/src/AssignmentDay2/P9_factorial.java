package AssignmentDay2;
import java.util.Scanner;
public class P9_factorial {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a nmber: ");
		int num = sc.nextInt();
		
		int fact =1, i=1;
		while(i<=num) {
			fact=fact*i;
			i++;
		}
		System.out.print("factorial of the number: "+fact);
		sc.close();
	}

	
}
