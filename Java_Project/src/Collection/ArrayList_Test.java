package Collection;
import java.util.*;
public class ArrayList_Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> list1 = new ArrayList<Integer>();
		ArrayList<String> list2 = new ArrayList<String>();
		
		list1.add(2);
		list1.add(null);
		list1.add(2);
		list1.add(null);
		
		System.out.println(list1);
		System.out.println(list2);
		
		System.out.println(list1.indexOf(null));
		
		System.out.println(list1.contains(1));
		System.out.println(list1.contains(2));
		
		System.out.println(list1.isEmpty());
		System.out.println(list2.isEmpty());
		
		System.out.println(list1.lastIndexOf(null));
		System.out.println(list2.lastIndexOf(null));
		
		System.out.println(list1.remove(null));
		System.out.println(list1);
		//System.out.println(list1.remove(2)); //Index based
		//System.out.println(list1);
		System.out.println(list1);
		System.out.println(list1.removeFirst());
		System.out.println(list1.removeLast());
		System.out.println("Current list:" +list1);
		
		System.out.println(list1.set(0, 3));
		System.out.println("Current list:" +list1);
		
		list1.add(0,1);
		list1.add(1,2);
		System.out.println("Current list:" +list1);
		System.out.println(list1.get(1));
		System.out.println(list1.getFirst());
		System.out.println(list1.getLast());
		
		System.out.println("Current list:" +list1);
		System.out.println("Reverse: "+list1.reversed());

	}

}
