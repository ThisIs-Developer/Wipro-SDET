package FOS;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("👤 Username: ");
        String username = sc.nextLine();
        System.out.print("🔒 Password: ");
        String password = sc.nextLine();
        if (!LoginService.login(username, password)) {
            System.out.println("❌ Login failed. Exiting...");
            return;
        }
        while (true) {

            System.out.println("\nFood Ordering System");
            System.out.println("1. Add Customer");
            System.out.println("2. View Customers");
            System.out.println("3. Add Food Item");
            System.out.println("4. View Menu");
            System.out.println("5. Place Order");
            System.out.println("6. Generate Bill");
            System.out.println("7. Exit");
            System.out.print("Choose option: ");
            int choice;
            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("❌ Invalid input! Enter numbers only.");
                continue;
            }
            switch (choice) {
                case 1:
                    CustomerService.addCustomer(sc);
                    break;
                case 2:
                    CustomerService.viewCustomers();
                    break;
                case 3:
                    MenuService.addItem(sc);
                    break;
                case 4:
                    MenuService.viewMenu();
                    break;
                case 5:
                    OrderService.placeOrder(sc);
                    break;
                case 6:
                    BillingService.generateBill(sc);
                    break;
                case 7:
                    System.out.println("🔚 Goodbye!");
                    return;
                default:
                    System.out.println("❌ Invalid choice! Try again.");
            }
        }
    }
}