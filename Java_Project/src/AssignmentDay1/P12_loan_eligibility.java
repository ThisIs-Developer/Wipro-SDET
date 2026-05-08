package AssignmentDay1;
import java.util.Scanner;
public class P12_loan_eligibility {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your age: ");
        int age = sc.nextInt();
        System.out.print("Enter your salary: ");
        int salary = sc.nextInt();
        if (age >= 21 && salary >= 100000)
            System.out.println("Eligible for loan");
        else
            System.out.println("Not eligible");

        sc.close();
    }
}