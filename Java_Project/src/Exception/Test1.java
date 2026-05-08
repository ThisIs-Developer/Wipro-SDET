package Exception;

import java.util.Scanner;
public class Test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);	
		System.out.print("Enter a Number: ");
		int a = sc.nextInt();
		System.out.print("Enter another number: ");
		int b = sc.nextInt();
		try {
			System.out.println("Divison: "+(a/b));
			String str="Hello COding";
			System.out.println(str.charAt(23));
		}
//		catch(Exception e) {
//			System.out.println("Failed: "+e);
//		}
		catch(IndexOutOfBoundsException e) {
			System.out.println("Failed: "+e);
		}
		catch(ArithmeticException e) {
			System.out.println("Failed: "+e);
		}
		finally {
			System.out.println("Hello");
		}
		sc.close();
	}
}
