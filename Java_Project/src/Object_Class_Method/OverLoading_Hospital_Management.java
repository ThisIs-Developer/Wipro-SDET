package Object_Class_Method;

public class OverLoading_Hospital_Management {
	
	void details(String name) {
		System.out.println("Name: "+name);
	}
	void details(String name, int age) {
		System.out.println("Name: "+name+"\tAge: "+age);
	}
	void details(String name, int age, String status) {
		System.out.println("Name: "+name+"\tAge: "+age+"\tStatus: "+status);
	}
	
	public static void main(String[] args) {
		OverLoading_Hospital_Management hm = new OverLoading_Hospital_Management();
		hm.details("Baivab");
		hm.details("Baivab",23);
		hm.details("Baivab",23,"Dead");
	}

}
