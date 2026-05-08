package AssignmentDay2;
import java.util.Scanner;

public class P8_user_role {

    public static void main(String[] args){  	
        Scanner sc = new Scanner(System.in);
        System.out.println("1 Admin");
        System.out.println("2 User");
        System.out.println("3 Guest");
        System.out.print("Choose role: ");
        int choice = sc.nextInt();
        switch(choice) {
            case 1:
                System.out.println("Full access");
                break;
            case 2:
                System.out.println("Limited access");
                break;
            case 3:
                System.out.println("Only viw access");
                break;
            default:
                System.out.println("Invalid choice");
        }
        sc.close();
    }
}