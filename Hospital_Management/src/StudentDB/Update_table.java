package StudentDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Update_table {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/StudentDB";
        String user = "root";
        String password = "root";

      String addCol = "alter table students add address varchar(30)";
        String updCol = "update students set address=\"Kolkata\" where rollno=101;";

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(url, user, password);
            System.out.println("Connection created");

            Statement stmt = con.createStatement();

          stmt.executeUpdate(addCol);
            System.out.println("New column created in Students table");

            stmt.executeUpdate(updCol);
            System.out.println("Column updated in Students table");

            ResultSet rs = stmt.executeQuery("Select * from students");

            System.out.println("rollno\t name\t Per\t Email\t Address");

            while (rs.next()) {

                int rollno = rs.getInt("rollno");
                String name = rs.getString("name");
                int per = rs.getInt("per");
                String email = rs.getString("email");
                String address = rs.getString("address");

                System.out.println(
                        rollno + "\t " + name + "\t " + per + "\t " + email + "\t " + address);
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