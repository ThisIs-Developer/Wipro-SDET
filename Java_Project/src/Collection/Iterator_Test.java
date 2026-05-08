package Collection;

import java.util.LinkedList;
import java.util.ListIterator;

public class Iterator_Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList<String> list1 =new LinkedList<String>();
		
		list1.add("C");
		list1.add("CPP");
		list1.add(null);
		list1.add("C");
		list1.add("Java");
		list1.add("Py");
		list1.add(null);
		
		System.out.println("Cur List: "+list1);
		
		ListIterator<String> it =list1.listIterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}

}
