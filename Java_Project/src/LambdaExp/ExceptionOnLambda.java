package LambdaExp;
interface Calcu{
	int op(int a,int b);
}
public class ExceptionOnLambda {

	public static void main(String[] args) {
		Calcu add = (a,b)->a+b;
		Calcu minus = (a,b)->a-b;
		Calcu multi = (a,b)->a*b;
		Calcu division1 = (a,b)->a/b;
		Calcu division2 = (a,b)->a/b;
		Calcu division3 = (a,b)->a/b;
		try {
		    System.out.println("Sum: " + add.op(10,20));
		} catch(Exception e) {
		    System.out.println(e);
		}
		try {
		    System.out.println("Minus: " + minus.op(10,20));
		} catch(Exception e) {
		    System.out.println(e);
		}
		try {
		    System.out.println("Multi: " + multi.op(10,20));
		} catch(Exception e) {
		    System.out.println(e);
		}
		try {
		    System.out.println("Division1: " + division1.op(10,20));
		} catch(Exception e) {
		    System.out.println(e);
		}
		try {
		    System.out.println("Division2: " + division2.op(10,0));
		} catch(Exception e) {
		    System.out.println(e);
		}
		try {
		    System.out.println("Division3: " + division3.op(10,0));
		} catch(Exception e) {
		    System.out.println(e);
		}
	}

}
