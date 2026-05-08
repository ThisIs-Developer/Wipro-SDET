package FOS;
import java.sql.*;
import java.util.Scanner;
public class OrderService {
	public static void placeOrder(Scanner sc) {
	    try (Connection con = DBConnection.getConnection()) {
	        System.out.print("Customer ID: ");
	        int customerId = Integer.parseInt(sc.nextLine());
	        String customerCheck = "SELECT * FROM customers WHERE customer_id=?";
	        PreparedStatement cps = con.prepareStatement(customerCheck);
	        cps.setInt(1, customerId);
	        ResultSet crs = cps.executeQuery();
	        if (!crs.next()) {
	            System.out.println("❌ Customer ID not found.");
	            return;
	        }
	        System.out.print("Item ID: ");
	        int itemId = Integer.parseInt(sc.nextLine());
	        String itemCheck = "SELECT * FROM menu WHERE item_id=?";
	        PreparedStatement ips = con.prepareStatement(itemCheck);
	        ips.setInt(1, itemId);
	        ResultSet irs = ips.executeQuery();
	        if (!irs.next()) {
	            System.out.println("❌ Item ID not found.");
	            return;
	        }
	        System.out.print("Quantity: ");
	        int quantity = Integer.parseInt(sc.nextLine());
	        System.out.print("Order Date (YYYY-MM-DD): ");
	        String date = sc.nextLine();
	        String sql =
	            "INSERT INTO orders(customer_id, item_id, quantity, order_date) VALUES(?,?,?,?)";
	        PreparedStatement ps = con.prepareStatement(sql);
	        ps.setInt(1, customerId);
	        ps.setInt(2, itemId);
	        ps.setInt(3, quantity);
	        ps.setDate(4, Date.valueOf(date));
	        ps.executeUpdate();
	        System.out.println("✅ Order placed successfully.");
	    } catch (NumberFormatException e) {
	        System.out.println("❌ Invalid number entered.");
	    } catch (IllegalArgumentException e) {
	        System.out.println("❌ Invalid date format. Use YYYY-MM-DD.");
	    } catch (Exception e) {
	        System.out.println("❌ Error placing order.");
	    }
	}
}