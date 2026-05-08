package AssignmentDay2;
import java.util.*;

public class P5_food_item {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;
        System.out.println("1 Chowmin");
        System.out.println("2 Egg Roll");
        System.out.println("3 Momos");
        System.out.println("4 Tea");
        System.out.println("5 Coffee");
        System.out.print("Enter item number: ");
        choice = sc.nextInt();
        switch(choice) {
            case 1:
                System.out.println("You selected: Chowmim");
                System.out.println("Price: ₹120");
                break;
            case 2:
                System.out.println("You selected: EGg Roll");
                System.out.println("Price: ₹90");
                break;
            case 3:
                System.out.println("You selected: Momos");
                System.out.println("Price: ₹100");
                break;
            case 4:
                System.out.println("You selected: Tea");
                System.out.println("Price: ₹40");
                break;
            case 5:
                System.out.println("You selected: coffee");
                System.out.println("Price: ₹50");
                break;
            default:
                System.out.println("invalid choice");
        }
        sc.close();
    }
}