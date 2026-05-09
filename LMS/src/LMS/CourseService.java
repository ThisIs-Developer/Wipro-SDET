package LMS;

import java.sql.*;
import java.util.Scanner;

public class CourseService {

    public static void addCourse(Scanner sc) {

        try(Connection con = DBConnection.getConnection()) {

            System.out.print("Course Name: ");
            String name = sc.nextLine();

            System.out.print("Duration: ");
            String duration = sc.nextLine();

            System.out.print("Fee: ");
            double fee = Double.parseDouble(sc.nextLine());

            String sql = "insert into courses(course_name, duration, fee) values(?,?,?)";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, duration);
            ps.setDouble(3, fee);

            ps.executeUpdate();

            System.out.println("✅ Course Added Successfully");

        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static void viewCourses() {

        try(Connection con = DBConnection.getConnection()) {

            String sql = "select * from courses";

            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while(rs.next()) {

                System.out.println(
                    rs.getInt("course_id") + "\t" +
                    rs.getString("course_name") + "\t" +
                    rs.getString("duration") + "\t" +
                    rs.getDouble("fee")
                );
            }

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}