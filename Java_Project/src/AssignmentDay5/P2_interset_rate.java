package AssignmentDay5;

class InterestRate extends Bank {

    public double getInterestRate() {
        return 6.5;
    }
}

public class P2_interset_rate {
	public static void main(String[] args) {
		Bank b1 = new InterestRate();
        System.out.println("Interest Rate: "+b1.getInterestRate()+"%");
	}
}