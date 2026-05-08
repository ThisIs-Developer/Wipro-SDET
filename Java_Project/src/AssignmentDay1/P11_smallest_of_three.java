package AssignmentDay1;
import java.util.Scanner;

public class P11_smallest_of_three {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
        System.out.print("Enter first number: ");
        int num1 = sc.nextInt();
        System.out.print("Enter second number: ");
        int num2 = sc.nextInt();
        System.out.print("Enter third number: ");
        int num3 = sc.nextInt();

        if (num1 <= num2 && num1 <= num3)
            System.out.println("First is smallest");
        else if (num2 <= num1 && num2 <= num3)
            System.out.println("Second is smallest");
        else
            System.out.println("Third is smallest");
        sc.close();
    }
}