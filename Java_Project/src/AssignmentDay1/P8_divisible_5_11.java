package AssignmentDay1;
import java.util.Scanner;
public class P8_divisible_5_11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a number: ");
        int num = sc.nextInt();

        if (num % 5 == 0 && num % 11 == 0)
            System.out.println("Divisible by both");
        else
            System.out.println("Not divisible by both");

        sc.close();
    }
}