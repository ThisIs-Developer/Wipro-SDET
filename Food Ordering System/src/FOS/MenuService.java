package FOS;
import java.sql.*;
import java.util.Scanner;

public class MenuService {
    public static void addItem(Scanner sc) {
        try(Connection con = DBConnection.getConnection()) {
            sc.nextLine();
            System.out.print("Item Name: ");
            String itemName = sc.nextLine();
            System.out.print("Price: ");
            double price = sc.nextDouble();
            String sql ="insert into menu(item_name, price) VALUES(?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, itemName);
            ps.setDouble(2, price);
            ps.executeUpdate();
            System.out.println("✅ Item Added");
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    public static void viewMenu() {
        try(Connection con = DBConnection.getConnection()) {
            String sql = "SELECT * FROM menu";
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery(sql);
            System.out.println("\tMENU");
            while(rs.next()) {
                System.out.println(
                	rs.getInt("item_id") + "\t " +
                    rs.getString("item_name") + "\t rs." +
                    rs.getDouble("price")
                );
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}