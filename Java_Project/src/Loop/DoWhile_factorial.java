package Loop;
import java.util.Scanner;

public class DoWhile_factorial {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number: ");
		int a = sc.nextInt();
		int fact=1, i=1 ;
		
		do {
			fact=fact*i;
			i++;
			
		}while(i<=a);
		System.out.println("Fact: "+fact);
		sc.close();
	}

}
