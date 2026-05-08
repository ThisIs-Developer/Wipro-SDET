package StudentDB;

import java.sql.*;

public class JDBC_Con {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        String url = "jdbc:mysql://localhost:3306/StudentDB";
        String user = "root";
        String password = "root";

        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection con = DriverManager.getConnection(url, user, password);
        System.out.println("Connection created");

        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("Select * from students");

        System.out.println("Roll No\t Name\t Percentage");

        while (rs.next()) {
            int rollno = rs.getInt("rollno");
            String name = rs.getString("name");
            int pre = rs.getInt("per");
            String email = rs.getString("email");

            System.out.println(rollno + "\t " + name + "\t " + pre + "\t " + email);
        }

        rs.close();
        stmt.close();
        con.close();
    }
}