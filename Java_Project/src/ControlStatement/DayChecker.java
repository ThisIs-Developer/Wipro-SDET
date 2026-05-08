package ControlStatement;
import java.util.*;

public class DayChecker {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a Day: ");
        String curDay = sc.nextLine();

        if (curDay.equals("Monday") || curDay.equals("Tuesday") ||
            curDay.equals("Wednesday") || curDay.equals("Thursday") ||
            curDay.equals("Friday")) {

            System.out.println("Working Day");

        } else if (curDay.equals("Saturday") || curDay.equals("Sunday")) {

            System.out.println("Off Day");

        } else {
            System.out.println("Invalid Day");
        }

        sc.close();
    }
}