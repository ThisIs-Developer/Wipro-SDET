package ControlStatement;

public class Condidtion_If_ElseIf {

    public static void main(String[] args) {

        int marks = 80;

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
    }
}