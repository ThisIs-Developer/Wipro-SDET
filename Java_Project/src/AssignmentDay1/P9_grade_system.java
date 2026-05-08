package AssignmentDay1;

import java.util.Scanner;

public class P9_grade_system {
    public static void main(String[] args) {
    	System.out.println("Enter your marks: ");
        Scanner sc = new Scanner(System.in);
        int marks = sc.nextInt();

        if (marks < 0 || marks > 100) {
            System.out.println("Invalid Marks");

        } else if (marks >= 75) {
            System.out.println("Distinction");

            if (marks >= 95) {
                System.out.println("A++");
            } else if (marks >= 90) {
                System.out.println("A+");
            } else {
                System.out.println("A");
            }

        } else if (marks >= 60) {
            System.out.println("First Class");

        } else if (marks >= 50) {
            System.out.println("Second Class");

        } else if (marks >= 40) {
            System.out.println("Pass");

        } else {
            System.out.println("Fail");
        }

        sc.close();
    }
}