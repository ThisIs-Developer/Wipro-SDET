package Encapsulation;
class BankAccount{
	private double balance;
	
	public void deposite(double amount) {
		if(amount>0) {
			balance+=amount;
			System.out.println("Success");
		}
		else {
			System.out.println("Failed");
		}
	}
	
	public void withdraw(double amount) {
		if(amount>0) {
			balance = balance-amount;
			System.out.println("Success");
		}
		else {
			System.out.println("Failed");
		}
	}
	public void getBalance() {
		System.out.println("Baance: "+balance);
	}
}

public class Bank {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BankAccount ba = new BankAccount();
		ba.deposite(100);
		ba.getBalance();
		ba.deposite(200);
		ba.getBalance();
		ba.withdraw(100);
		ba.getBalance();
		Customer c = new Customer();
		System.out.println("Customer Name: "+c.getname());
		System.out.println("Customer ID: "+c.getId());
	}

}
