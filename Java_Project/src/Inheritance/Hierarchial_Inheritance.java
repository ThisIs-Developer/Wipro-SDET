package Inheritance;

class Grandparent {
	void openland() {
		System.out.println("Openland for commercial use");
	}
}

class Parent1 extends Grandparent {
	void flat() {
		System.out.println("2BHK");
	}
	void car() {
		System.out.println("Baleno1 Petrol car");
	}
}

class Parent2 extends Grandparent {
	void flat() {
		System.out.println("4BHK");
	}
	void car() {
		System.out.println("Baleno2 Petrol car");
	}
}

class Childp1 extends Parent1 {
	void bike() {
		System.out.println("Pulsar");
	}
}

class Child1p2 extends Parent2 {
	void bike() {
		System.out.println("Pulsar");
	}
}

class Child2p2 extends Parent2 {
	void bike() {
		System.out.println("Activa");
	}
}

public class Hierarchial_Inheritance {

	public static void main(String[] args) {
		Childp1 mohan = new Childp1();
		mohan.openland();
		mohan.flat();
		mohan.car();
		mohan.bike();
		System.out.println();
		Child1p2 ram = new Child1p2();
		ram.openland();
		ram.flat();
		ram.car();
		ram.bike();
		System.out.println();
		Child2p2 shyam = new Child2p2();
		shyam.openland();
		shyam.flat();
		shyam.car();
		shyam.bike();
	}
}