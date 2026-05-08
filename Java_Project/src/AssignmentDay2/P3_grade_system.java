package AssignmentDay2;

import java.util.Scanner;

public class P3_grade_system {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
        System.out.print("Enter grade (A, B, C, D, F): ");
        char grade = sc.next().charAt(0);

        switch (grade) {
            case 'A':
            	System.out.println("Excellent");break;
            case 'B':
            	System.out.println("Good job");break;
            case 'C':
            	System.out.println("Average"); break;
            case 'D':
                System.out.println("Below average");break;
            case 'F':
                System.out.println("Fail");break;
            default:
                System.out.println("Invalid grade");
        }

        sc.close();
    }
}