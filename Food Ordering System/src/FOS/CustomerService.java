package FOS;
import java.sql.*;
import java.util.Scanner;

public class CustomerService {
    public static void addCustomer(Scanner sc) {
        try(Connection con = DBConnection.getConnection()) {
            sc.nextLine();
            System.out.print("Enter name: ");
            String name = sc.nextLine();
            System.out.print("Enter phone: ");
            String phone = sc.nextLine();
            System.out.print("Enter address: ");
            String address = sc.nextLine();
            String sql =
                    "insert into customers(name, phone, address) values(?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, phone);
            ps.setString(3, address);
            ps.executeUpdate();
            System.out.println("✅ Customer Added Successfully");
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    public static void viewCustomers() {
        try(Connection con = DBConnection.getConnection()) {
            String sql = "SELECT * FROM customers";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()) {
                System.out.println(
                        rs.getInt("customer_id") + "\t " +
                        rs.getString("name") + "\t " +
                        rs.getString("phone") + "\t " +
                        rs.getString("address")
                );
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}