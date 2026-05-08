package Collection;
import java.util.*;
public class P2_Search_Element {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> arr = new ArrayList<Integer>();
		for(int i=0;i<=9;i++) {
			arr.add(i);
		}
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter a number: ");
		int num =sc.nextInt();
		
		System.out.println(arr.contains(num));
		sc.close();
	}

}
