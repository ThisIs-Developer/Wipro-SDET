package Collection;

import java.util.*;
public class P5_Reverse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Character> arr = new ArrayList<Character>();
		arr.add('B');
		arr.add('A');
		arr.add('I');
		arr.add('V');
		arr.add('A');
		arr.add('B');
		System.out.println("Before:" +arr);
		Collections.reverse(arr);
		System.out.println("After: "+arr);
	}

}
