package AssignmentDay2;
import java.util.Scanner;
public class P4_atm_menu {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
	    int choice;
	    double balance = 848769.89;
	
	    do {
	        System.out.println("1. Check Balance");
	        System.out.println("2. Deposit");
	        System.out.println("3. Withdraw");
	        System.out.println("4. Exit");
	        System.out.print("Enter choice: ");
	
	        choice = sc.nextInt();
	
	        if (choice == 1) {
	            System.out.println("Balance is: " + balance);
	        }
	        else if (choice == 2) {
	            System.out.print("Enter amount: ");
	            double amt = sc.nextDouble();
	            balance = balance + amt;
	            System.out.println("Money deposited");
	        }
	        else if (choice == 3) {
	            System.out.print("Enter amount: ");
	            double amt = sc.nextDouble();
	
	            if (amt <= balance) {
	                balance = balance - amt;
	                System.out.println("Take your cash");
	            } else {
	                System.out.println("Not enough balance");
	            }
	        }
	        else if (choice == 4) {
	            System.out.println("Exit");
	        }
	        else {
	            System.out.println("Wrong choice");
	        }
	
	    } while (choice != 4);
	
	    sc.close();
	}
}
