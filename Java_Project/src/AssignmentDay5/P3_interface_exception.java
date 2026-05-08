package AssignmentDay5;
interface Cal {
    int divide(int a, int b);
}

class Divide implements Cal {
    public int divide(int a, int b) {
        try {
            return a/b;
        } catch (ArithmeticException e) {
            System.out.println(e);
            return 0;
        }
    }
}
public class P3_interface_exception {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Divide c = new Divide();
        System.out.println("Result: " + c.divide(10, 2));
        System.out.println("Result: " + c.divide(10, 0));
	}

}
