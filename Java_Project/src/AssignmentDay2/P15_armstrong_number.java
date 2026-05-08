package AssignmentDay2;

import java.util.Scanner;

public class P15_armstrong_number {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = sc.nextInt();
        int ori = num;
        int ori1 = num;
        int count = 0;
        int sum = 0;
        
        while (num > 0) {
            num = num / 10;
            count++;
        }
        while (ori1 > 0) {
            int rem = ori1 % 10;
            int power = 1;
            for (int i=0;i<count;i++) {
                power= power*rem;
            }
            sum += power;
            ori1 = ori1/10;
        }
        if (sum == ori) {
            System.out.println("Armstrong no");
        } else {
            System.out.println("Not Armstrong no");
        }

        sc.close();
    }
}