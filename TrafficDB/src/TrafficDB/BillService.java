package TrafficDB;
import java.sql.*;
import java.time.LocalDate;
import java.util.Scanner;

public class BillService {
    public static void generateBill(Scanner sc) {
        try (Connection con = DBConnection.getConnection()) {
            System.out.print("Enter Violation ID: ");
            int id = sc.nextInt();
            String sql = "SELECT * FROM violations WHERE violation_id=?";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int violationId = rs.getInt("violation_id");
                String ownerName = rs.getString("owner_name");
                String vehicleNumber = rs.getString("vehicle_number");
                double fineAmount = rs.getDouble("fine_amount");
                System.out.println("\nTRAFFIC FINE BILL");
                System.out.println("Violation ID : " + violationId);
                System.out.println("Owner Name   : " + ownerName);
                System.out.println("Vehicle No   : " + vehicleNumber);
                System.out.println("Reason       : " + rs.getString("reason"));
                System.out.println("Fine Amount  : " + fineAmount);
                System.out.println("Date         : " + rs.getDate("violation_date"));
                System.out.println("\n");
                String insertBill = "INSERT INTO submitted_bills(violation_id,owner_name,vehicle_number,fine_amount,submit_date) VALUES(?,?,?,?,?)";
                PreparedStatement billPs = con.prepareStatement(insertBill);
                billPs.setInt(1, violationId);
                billPs.setString(2, ownerName);
                billPs.setString(3, vehicleNumber);
                billPs.setDouble(4, fineAmount);
                billPs.setDate(5, Date.valueOf(LocalDate.now()));
                billPs.executeUpdate();
                System.out.println("✅ Bill Submitted Successfully");
            } else {
                System.out.println("❌ Violation Not Found");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}