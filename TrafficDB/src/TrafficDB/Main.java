package TrafficDB;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("👮 Username: ");
        String username = sc.nextLine();
        System.out.print("🔒 Password: ");
        String password = sc.nextLine();
        if (!LoginService.login(username, password)) {
            System.out.println("❌ Login failed. Exiting...");
            return;
        }
        while (true) {
            System.out.println("\n Traffic Violation Management Menu");
            System.out.println("1. Add Vehicle Violation");
            System.out.println("2. View Vehicle Violations");
            System.out.println("3. Generate Fine Bill");
            System.out.println("4. Exit");
            System.out.print("Choose option: ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1 -> ViolationService.addViolation(sc);
                case 2 -> ViolationService.viewViolations();
                case 3 -> BillService.generateBill(sc);
                case 4 -> {
                    System.out.println("🔚 Goodbye!");
                    return;
                }
                default -> System.out.println("❓ Invalid option");
            }
        }
    }
}