package Loop;
import java.util.Scanner;

public class Do_NaturalSum {
	public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter number: ");
	int a = sc.nextInt();
	int sum = 0, i = 1;
	do {
        sum = sum + i;
        i++;
    } while (i <= a);

    System.out.println("Sum: " + sum);
	sc.close();
	}
}
