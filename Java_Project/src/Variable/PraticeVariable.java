package Variable;

public class PraticeVariable {

	static String compName = "Swiggy";
	int customerID = 0202;
	String customername = "Baivab";
	
	void Order (int totalOrde, String nameFood, double price) {
		System.out.println("Total Number of Food Order: "+totalOrde);
		System.out.println("Food Name: "+nameFood);
		System.out.println("Price: "+price+"\n");
	}
	void Delivery (String address, int Deliverytime) {
		System.out.println("Adreess to Deliver: "+address);
		System.out.println("Delivery TIme: "+Deliverytime);
	}
	
	public static void main (String[] args) {
		PraticeVariable pv = new PraticeVariable();
		System.out.println("Delivery App: "+compName);
		System.out.println("Customer ID: "+pv.customerID);
		System.out.println("Customer Name: "+pv.customername+"\n");
		pv.Order(1, "Samosha", 140.43);
		pv.Delivery("Kolkata", 32);
	}
}
