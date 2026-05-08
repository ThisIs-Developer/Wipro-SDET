package ControlStatement;
import java.util.Scanner;
public class SwitchCase_Size {

	public static void main(String[] args) {
		System.out.println("Enter your size");
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		
		switch(size) {
		case 26: System.out.println("Extra samll");
			break;
		case 28: System.out.println("Samll");
			break;
		case 30: System.out.println("Large");
			break;
		case 32: System.out.println("Extra large");
			break;
		case 34: System.out.println("Extra Extra LArge");
			break;
		default: System.out.println("Invaild size");
		}
		
		sc.close();
	}

}
