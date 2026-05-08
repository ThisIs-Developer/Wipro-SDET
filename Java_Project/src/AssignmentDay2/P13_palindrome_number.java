package AssignmentDay2;
import java.util.Scanner;

public class P13_palindrome_number {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter a number: ");
		int num = sc.nextInt();
		int ori = num;
		int rev = 0, last=0;
		while(num>0) {
			last=num%10;
			rev=rev*10+last;
			num =num/10;
		}
		if(ori==rev)
		{
			System.out.println("Its palindrome no");
		}
		else
			System.out.println("Its not palindrome no");
		sc.close();
	}

}
