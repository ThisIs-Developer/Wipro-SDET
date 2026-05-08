package Enum;

enum Day {
    SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY
}

public class Day_checker {

    public static void main(String[] args) {
        Day today = Day.WEDNESDAY;

        System.out.println("Today is: " + today);

        switch (today) {
            case SUNDAY:
                System.out.println("Relax, it's Sunday!");
                break;

            case MONDAY:
                System.out.println("Back to work.");
                break;

            case TUESDAY:
                System.out.println("Keep going.");
                break;

            case WEDNESDAY:
                System.out.println("Midweek day.");
                break;

            case THURSDAY:
                System.out.println("Almost there.");
                break;

            case FRIDAY:
                System.out.println("Weekend is near!");
                break;

            case SATURDAY:
                System.out.println("Enjoy your Saturday!");
                break;
        }
    }
}