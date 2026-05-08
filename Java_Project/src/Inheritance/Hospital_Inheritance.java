package Inheritance;

class Hospital{
	void details(String name, int age)
	{
		System.out.println("Name: "+name );
		System.out.println("Age: "+age);
	}
}

class Doctor extends Hospital{
	void Salary() {
		System.out.println("Salary: 19705347 INR");
	}
}

class Patient extends Hospital{
	void fees() {
		System.out.println("Fees: 674 INR");
	}
}
public class Hospital_Inheritance {

	public static void main(String[] args) {
		Doctor d = new Doctor();
		d.details("REam", 43);
		d.Salary();
		Patient p = new Patient();
		p.details("Raja", 90);
		p.fees();
	}

}
