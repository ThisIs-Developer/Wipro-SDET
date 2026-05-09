package LMS;

import java.sql.*;
import java.util.Scanner;

public class GradeService {

    public static void addGrade(Scanner sc) {

        try(Connection con = DBConnection.getConnection()) {

            System.out.print("Student ID: ");
            int studentId = Integer.parseInt(sc.nextLine());

            System.out.print("Course ID: ");
            int courseId = Integer.parseInt(sc.nextLine());

            System.out.print("Marks: ");
            double marks = Double.parseDouble(sc.nextLine());

            String grade;

            if(marks >= 90)
                grade = "A";
            else if(marks >= 75)
                grade = "B";
            else if(marks >= 60)
                grade = "C";
            else
                grade = "F";

            String sql = "insert into grades(student_id, course_id, marks, grade) values(?,?,?,?)";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, studentId);
            ps.setInt(2, courseId);
            ps.setDouble(3, marks);
            ps.setString(4, grade);

            ps.executeUpdate();

            System.out.println("✅ Grade Added Successfully");

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}