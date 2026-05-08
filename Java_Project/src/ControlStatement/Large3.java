package ControlStatement;

public class Large3 {
    public static void main(String[] args) {
        int a = 23, b = 45, c = 44;

        if (a > b && a > c) {
            System.out.println("Large: A " + a);
        } else if (b > a && b > c) {
            System.out.println("Large: B " + b);
        } else {
            System.out.println("Large: C " + c);
        }
    }
}