package ControlStatement;
import java.util.Scanner;

public class Calculator_SwitchCase {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);	
		System.out.print("Enter a Number: ");
		int a = sc.nextInt();
		System.out.print("Enter another number: ");
		int b = sc.nextInt();
		System.out.print("Enter operation you want to perfrom (+ , - , * , / ) : ");
		String op = sc.next();
		switch (op) {
		case "+":
			System.out.println("Sum: "+(a+b));
			break;
		case "-":
			System.out.println("Minus: "+(a-b));
			break;
		case "*":
			System.out.println("Multiplication: "+(a*b));
			break;
		case "/":
			System.out.println("Divison: "+(a/b));
			break;
		default: System.out.println("INvaild Op");
		}
		sc.close();
	}

}
