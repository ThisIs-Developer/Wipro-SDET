package TrafficDB;
import java.sql.*;
import java.util.Scanner;
public class ViolationService {
    public static void addViolation(Scanner sc) {
        try (Connection con = DBConnection.getConnection()) {
            sc.nextLine();
            System.out.print("Enter Owner Name: ");
            String ownerName = sc.nextLine();
            System.out.print("Enter Vehicle Number: ");
            String vehicleNumber = sc.nextLine();
            System.out.print("Enter Reason: ");
            String reason = sc.nextLine();
            System.out.print("Enter Fine Amount: ");
            double fineAmount = sc.nextDouble();
            sc.nextLine();
            System.out.print("Enter Violation Date (YYYY-MM-DD): ");
            String date = sc.nextLine();
            String sql = "INSERT INTO violations(owner_name,vehicle_number,reason,fine_amount,violation_date) VALUES(?,?,?,?,?)";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, ownerName);
            ps.setString(2, vehicleNumber);
            ps.setString(3, reason);
            ps.setDouble(4, fineAmount);
            ps.setDate(5, Date.valueOf(date));
            ps.executeUpdate();
            System.out.println("✅ Vehicle Violation Added Successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void viewViolations() {
        try (Connection con = DBConnection.getConnection()) {
            String sql = "SELECT * FROM violations";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            System.out.println("\nVehicle Violations");
            while (rs.next()) {
                System.out.println("Violation ID : " + rs.getInt("violation_id"));
                System.out.println("Owner Name   : " + rs.getString("owner_name"));
                System.out.println("Vehicle No   : " + rs.getString("vehicle_number"));
                System.out.println("Reason       : " + rs.getString("reason"));
                System.out.println("Fine Amount  : " + rs.getDouble("fine_amount"));
                System.out.println("Date         : " + rs.getDate("violation_date"));
                System.out.println("\n");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}