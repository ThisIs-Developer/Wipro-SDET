package StudentDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Create_Table {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/StudentDB";
        String user = "root";
        String password = "root";

        String sql = "create table if not exists students("
                + "rollno int,"
                + "name varchar(50),"
                + "per int,"
                + "email varchar(50))";

        String insertSQL = "insert into students values"
                + "(101,'Neeva Sharma',98,'abc@gmail.com'),"
                + "(102,'Reeva Sharma',89,'Reeva@gmail.com'),"
                + "(103,'Shiva Upadhyay',79,'shiva@gmail.com')";

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(url, user, password);
            System.out.println("Connection created");

            Statement stmt = con.createStatement();

            stmt.executeUpdate(sql);
            System.out.println("Students table created");

            int rowInserted = stmt.executeUpdate(insertSQL);

            if (rowInserted > 0) {
                System.out.println("New student record inserted");
            }

            ResultSet rs = stmt.executeQuery("Select * from students");

            System.out.println("rollno\t name\t Per\t Email");

            while (rs.next()) {

                int rollno = rs.getInt("rollno");
                String name = rs.getString("name");
                int per = rs.getInt("per");
                String email = rs.getString("email");

                System.out.println(rollno + "\t " + name + "\t " + per + "\t " + email);
            }

            rs.close();
            stmt.close();
            con.close();

        } catch (SQLException e) {

            System.out.println(e);

        } catch (ClassNotFoundException e) {

            System.out.println(e);
        }
    }
}