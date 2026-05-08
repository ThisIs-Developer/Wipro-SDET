package Exception;

import java.util.Scanner;
public class Try_Catch1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);	
		System.out.print("Enter a Number: ");
		int a = sc.nextInt();
		System.out.print("Enter another number: ");
		int b = sc.nextInt();
		try {
			System.out.println("Divison: "+(a/b));
		}
		catch(Exception e) {
			System.out.println("Failed: "+e);
		}
		System.out.println("End of Code");
		sc.close();
	}

}
