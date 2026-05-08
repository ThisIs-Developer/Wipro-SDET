package Keyword;

abstract class Hospital {
    void name() {
        System.out.println("Life Hospital");
    }
}

interface NurseDuties {
    void Documents();
    void Patient();
}

interface DoctorDuties {
    void OT();
    void Operation();
}

class Nurse1 extends Hospital implements NurseDuties {
    public void Documents() {
        System.out.println("Nurse reading documents");
    }

    public void Patient() {
        System.out.println("Nurse checking patient");
    }
}

class Doctor1 extends Hospital implements DoctorDuties {
    public void OT() {
        System.out.println("Doctor going to OT");
    }

    public void Operation() {
        System.out.println("Doctor doing operation");
    }
}

public class Abstract_HMS {
    public static void main(String[] args) {
        Nurse1 n = new Nurse1();
        n.name();
        n.Documents();
        n.Patient();

        System.out.println("**************");

        Doctor1 d = new Doctor1();
        d.name();
        d.OT();
        d.Operation();
    }
}