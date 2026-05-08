package Loop;
import java.util.Scanner;
public class Pattern_Triangle{
	
	public static void main(String[] args) {
		Scanner sc =new Scanner ( System.in);
		System.out.println("Enter row number: ");
		int num = sc.nextInt();
//		LT
//		for(int i=1;i<=num;i++) {
//			for (int j = 1;j<=i;j++) {
//				System.out.print("*");
//			}
//			System.out.println();
//		}
//		RT
//		for(int i=1;i<=num;i++)
//		{
//		    for (int j = 1; j <= num - i; j++) {
//		        System.out.print(" ");
//		    }
//
//		    for (int k = 1; k <= i; k++) {
//		        System.out.print("*");
//		    }System.out.println();
//		}
//		LT Rev
//		for (int i = num; i >= 1; i--) {
//		    for (int j = 1; j <= i; j++) {
//		        System.out.print("*");
//		    }
//		    System.out.println();
//		}
//		RT Rev
//		for (int i=num; i>=1; i--) {
//		    for (int j=1; j<=num-i; j++) {
//		        System.out.print(" ");
//		    }
//		    for (int k = 1; k <= i; k++) {
//		        System.out.print("*");
//		    }
//		    System.out.println();
//		}
		
		//Perfect
		for (int i = 1; i <= num; i++) {
		    for (int j = 1; j <= num - i; j++) {
		        System.out.print(" ");
		    }
		    for (int k = 1; k <= (2 * i - 1); k++) {
		        System.out.print("*");
		    }
		    System.out.println();
		}
		
		//Diamond, Boader Triangle (Pratice)
		
		sc.close();
	}
}