package Collection;

import java.util.*;
public class P6_Update {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> arr = new ArrayList<String>();
		arr.add("Bengali");
		arr.add("English");
		arr.add("Biology");
		arr.add("Math");
		System.out.println("Before:" +arr);
		arr.set(3, "Stattistics");
		System.out.println("After: "+arr);
	}

}
