package ControlStatement;

public class Divisible {
    public static void main(String[] args) {
        int a = 11;

        if (a % 5 == 0 && a % 11 == 0) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}