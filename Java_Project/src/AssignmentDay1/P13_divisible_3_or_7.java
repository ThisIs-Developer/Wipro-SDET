package AssignmentDay1;
import java.util.Scanner;

public class P13_divisible_3_or_7 {
    public static void main(String[] args) {
    	System.out.print("Enter a number: ");
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        if (num % 3 == 0 || num % 7 == 0)
            System.out.println("Divisible");
        else
            System.out.println("Not divisible");

        sc.close();
    }
}