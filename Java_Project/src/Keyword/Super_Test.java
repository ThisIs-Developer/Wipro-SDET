package Keyword;

class Doctor {
    String name = "ram";

    Doctor() {
        System.out.println("Doctor Name: " + name);
    }
}

class Patient extends Doctor {
    String name = "shaym";

    Patient() {
        System.out.println("Patient Name: " + name);
        System.out.println("Doctor Name using super: " + super.name);
    }
}

public class Super_Test {
    public static void main(String[] args) {
        new Patient();
    }
}