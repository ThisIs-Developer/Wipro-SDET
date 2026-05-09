package LMS;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Username: ");
        String username = sc.nextLine();

        System.out.print("Password: ");
        String password = sc.nextLine();

        if(!LoginService.login(username, password)) {
            System.out.println("❌ Invalid Login");
            return;
        }

        while(true) {

            System.out.println("\n===== LMS MENU =====");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Add Course");
            System.out.println("4. View Courses");
            System.out.println("5. Enroll Student");
            System.out.println("6. Add Grade");
            System.out.println("7. Exit");

            System.out.print("Choose Option: ");

            int choice = Integer.parseInt(sc.nextLine());

            switch(choice) {

                case 1:
                    StudentService.addStudent(sc);
                    break;

                case 2:
                    StudentService.viewStudents();
                    break;

                case 3:
                    CourseService.addCourse(sc);
                    break;

                case 4:
                    CourseService.viewCourses();
                    break;

                case 5:
                    EnrollmentService.enrollStudent(sc);
                    break;

                case 6:
                    GradeService.addGrade(sc);
                    break;

                case 7:
                    System.out.println("✅ Exiting LMS...");
                    return;

                default:
                    System.out.println("❌ Invalid Choice");
            }
        }
    }
}