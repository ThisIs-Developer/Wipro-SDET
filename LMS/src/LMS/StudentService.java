package LMS;

import java.sql.*;
import java.util.Scanner;

public class StudentService {

    public static void addStudent(Scanner sc) {

        try(Connection con = DBConnection.getConnection()) {

            System.out.print("Student Name: ");
            String name = sc.nextLine();

            System.out.print("Email: ");
            String email = sc.nextLine();

            System.out.print("Course: ");
            String course = sc.nextLine();

            String sql = "insert into students(name, email, course) values(?,?,?)";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, email);
            ps.setString(3, course);

            ps.executeUpdate();

            System.out.println("✅ Student Added Successfully");

        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static void viewStudents() {

        try(Connection con = DBConnection.getConnection()) {

            String sql = "select * from students";

            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while(rs.next()) {

                System.out.println(
                    rs.getInt("student_id") + "\t" +
                    rs.getString("name") + "\t" +
                    rs.getString("email") + "\t" +
                    rs.getString("course")
                );
            }

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}