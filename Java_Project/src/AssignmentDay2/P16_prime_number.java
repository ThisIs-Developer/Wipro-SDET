package AssignmentDay2;
import java.util.Scanner;

public class P16_prime_number {

    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = sc.nextInt();
        if (num <= 1) {
            System.out.println("Not a prime number.");
        } else {
            int i;
            for (i = 2; i < num; i++) {
                if (num % i == 0) {
                    System.out.println("not a prime number.");
                    break;
                }
            }
            if (i == num) {
                System.out.println("Prime number.");
            }
        }
        sc.close();
	}
}
