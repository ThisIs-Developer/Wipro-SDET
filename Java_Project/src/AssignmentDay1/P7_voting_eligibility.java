package AssignmentDay1;

import java.util.Scanner;

public class P7_voting_eligibility {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your age: ");
        int age = sc.nextInt();
        if (age >= 18)
            System.out.println("Eligible");
        else
            System.out.println("Not Eligible");

        sc.close();
    }
}