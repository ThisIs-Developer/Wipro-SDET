package Exception;

import java.util.Scanner;

public class Throws_test {
	public static void main(String[] args) throws InterruptedException {
		Scanner sc = new Scanner(System.in);	
		System.out.print("Enter a Number: ");
		int a = sc.nextInt();
		System.out.print("Enter another number: ");
		int b = sc.nextInt();
		Thread.sleep(100);
		try {
			System.out.println("Divison: "+(a/b));
			String str="Hello COding";
			System.out.println(str.charAt(23));
		}
		catch(Exception e) {
			System.out.println("Failed: "+e);
		}
		finally {
			sc.close();
		}
	}

}
