package Loop;
import java.util.Scanner;
public class While_SumNatrual {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number: ");
		int a = sc.nextInt();
		int sum = 0, i = 0;
		while(i<=a)
		{
			System.out.println("Sum: "+sum);
			sum=sum+i;
			i++;
		}
		sc.close();
	}

}
