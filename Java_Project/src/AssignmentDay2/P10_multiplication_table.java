package AssignmentDay2;
import java.util.Scanner;

public class P10_multiplication_table {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number: ");
        int num = sc.nextInt();

        int i = 1;
        while(i <= 10) {
            System.out.println(num +"x"+i+"="+(num * i));
            i++;
        }
        sc.close();
    }
}