package LMS;

import java.sql.*;
import java.util.Scanner;

public class EnrollmentService {

    public static void enrollStudent(Scanner sc) {

        try(Connection con = DBConnection.getConnection()) {

            System.out.print("Student ID: ");
            int studentId = Integer.parseInt(sc.nextLine());

            System.out.print("Course ID: ");
            int courseId = Integer.parseInt(sc.nextLine());

            System.out.print("Enrollment Date (YYYY-MM-DD): ");
            String date = sc.nextLine();

            String sql = "insert into enrollments(student_id, course_id, enrollment_date) values(?,?,?)";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, studentId);
            ps.setInt(2, courseId);
            ps.setDate(3, Date.valueOf(date));

            ps.executeUpdate();

            System.out.println("✅ Student Enrolled Successfully");

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}