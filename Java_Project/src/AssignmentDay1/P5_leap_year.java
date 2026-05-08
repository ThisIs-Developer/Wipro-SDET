package AssignmentDay1;

import java.util.Scanner;
public class P5_leap_year {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        System.out.print("Enter a YEar: ");
        int y = sc.nextInt();
        if ((y % 4 == 0 && y % 100 != 0) || y % 400 == 0) {
        	System.out.print("Leap year");}
        else {
        	System.out.print("Not yeap year");
        }
        sc.close();
	}

}
