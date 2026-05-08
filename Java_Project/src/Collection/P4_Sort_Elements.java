package Collection;
import java.util.*;

public class P4_Sort_Elements {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> arr = new ArrayList<Integer>();
		arr.add(43);
		arr.add(34);
		arr.add(74);
		arr.add(34);
		arr.add(56);
		arr.add(12);
		arr.add(63);
		System.out.println("Before sort:" +arr);
		Collections.sort(arr);
		System.out.println("After sort: "+arr);
	}

}
