package Keyword;

public class Static_Test {
	
	// Static Variable
	static String compName = "Swiggy";
	int customerID = 0202;
	String customername = "Baivab";
	void Order (String nameFood, double price) {
		System.out.println("Food Name: "+nameFood);
		System.out.println("Price: "+price+"\n");
	}
	
	// Static method
	static void Delivery (String address, int Deliverytime) {
		System.out.println("Adreess to Deliver: "+address);
		System.out.println("Delivery TIme: "+Deliverytime);
	}
	// Block
	{
		System.out.println("Apple Store");
	}
		
	// Static Block
	static {
		System.out.println("Food Delivery App");
	}
	
	// Block
	{
		System.out.println("Playstore");
	}
	
	public static void main (String[] args) {
		Static_Test st = new Static_Test();
		System.out.println("Delivery App: "+compName);
		System.out.println("Customer ID: "+st.customerID);
		System.out.println("Customer Name: "+st.customername+"\n");
		st.Order("Samosha", 140.43);
		Delivery("Kolkata", 32);
	}
	
	// Static Method
}
