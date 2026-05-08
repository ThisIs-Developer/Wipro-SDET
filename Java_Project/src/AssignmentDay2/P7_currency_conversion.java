package AssignmentDay2;
import java.util.Scanner;

public class P7_currency_conversion {
	
	public static void main(String[] args){  	
		Scanner sc = new Scanner(System.in);
        System.out.println("1 INR to USD");
        System.out.println("2 INR to EUR");
        System.out.print("Choose option: ");
        int choice = sc.nextInt();
        System.out.print("Enter amount in inr: ");
        double inr = sc.nextDouble();

        switch(choice) {
            case 1:
                System.out.println("Converted Amount: "+(inr*0.012)+"USD");
                break;
            case 2:
                System.out.println("Converted Amount: "+(inr*0.011)+"EUR");
                break;
            default:
                System.out.println("Invaild choice");
        }
        sc.close();
	}

}
