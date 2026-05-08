package AssignmentDay2;
import java.util.Scanner;

public class P14_sum_digits {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter a number: ");
		int no1 = sc.nextInt();
		System.out.print("Enter another number: ");
		int no2 = sc.nextInt();
		int sum = 0;
		while(sum==0) {
			sum = no1+no2;
			break;
		}
		System.out.println("Sum: "+sum);
		sc.close();
	}
}
