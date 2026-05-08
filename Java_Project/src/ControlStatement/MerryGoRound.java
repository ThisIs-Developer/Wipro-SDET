package ControlStatement;

public class MerryGoRound {

    int age = 19;
    int height = 140;

    public void check() {
        if (age >= 18 && height >= 150) {
            System.out.println("Eligible to ride");
        } else {
            System.out.println("Not eligible bacha");
        }
    }

    public static void main(String[] args) {
        MerryGoRound mgr = new MerryGoRound();
        mgr.check();
    }
}