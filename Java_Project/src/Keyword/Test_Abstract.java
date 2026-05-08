package Keyword;

abstract class Vehicle {
    abstract void nooftyres();

    void type() {
        System.out.println("Petrol/Diesel/electric");
    }
}

class Scooter extends Vehicle {
    void nooftyres() {
        System.out.println("no of tyre for scooter = 2");
    }
}

class Car extends Vehicle {
    void nooftyres() {
        System.out.println("no of tyre for car = 4");
    }
}

public class Test_Abstract {
    public static void main(String[] args) {
        Scooter sc = new Scooter();
        sc.nooftyres();
        sc.type();

        System.out.println("*********************");

        Car c = new Car();
        c.nooftyres();
        c.type();
    }
}