package AssignmentDay1;
import java.util.Scanner;
public class P10_number_type {
    public static void main(String[] args) {
    	System.out.print("Enter a number: ");
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        if (num == 0)
            System.out.println("Zero");
        else if (num > 0)
            System.out.println("Positive");
        else
            System.out.println("Negative");

        sc.close();
    }
}