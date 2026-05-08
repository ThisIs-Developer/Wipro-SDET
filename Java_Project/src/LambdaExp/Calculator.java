package LambdaExp;
interface Cal{
	int op(int a,int b);
}
public class Calculator{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cal add = (a,b)->a+b;
		System.out.println("Sum: "+add.op(10,20));
		Cal minus = (a,b)->a-b;
		System.out.println("Minus: "+minus.op(10,20));
		Cal multi = (a,b)->a*b;
		System.out.println("multi: "+multi.op(10,20));
		Cal division = (a,b)->a+b;
		System.out.println("Division: "+division.op(10,20));
		

	}

}
