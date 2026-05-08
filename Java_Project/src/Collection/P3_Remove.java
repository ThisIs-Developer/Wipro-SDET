package Collection;

import java.util.*;
public class P3_Remove {
	public static void main(String[] args)
	{
		ArrayList<String> arr = new ArrayList<String>();
		arr.add("Appel");
		arr.add("Mango");
		arr.add("Lichi");
		arr.add("Mango");
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter a fruit name: ");
		String fr =sc.nextLine();
		
		System.out.println(arr);
		arr.remove(fr);
		System.out.println(arr);
		sc.close();
	}
}
