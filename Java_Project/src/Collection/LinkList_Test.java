package Collection;
import java.util.LinkedList;
import java.util.List;
public class LinkList_Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList<String> list1 =new LinkedList<String>();
		List<String> list2 = new LinkedList<String>();
		
		list1.add("C");
		list1.add("CPP");
		list1.add(null);
		list1.add("C");
		list1.add("Java");
		list1.add("Py");
		list1.add(null);
		
		System.out.println("Cur List: "+list1);
		
		System.out.println(list1.indexOf(null));
		
		System.out.println(list1.contains("java"));
		System.out.println(list1.contains("Java"));
		
		System.out.println(list1.isEmpty());
		System.out.println(list2.isEmpty());
		
		System.out.println(list1.lastIndexOf(null));
		System.out.println(list2.lastIndexOf(null));

		System.out.println("Cur List: "+list1);
		System.out.println(list1.remove(null));
		System.out.println("Cur List: "+list1);
		System.out.println(list1.remove(0));
		System.out.println("Cur List: "+list1);
		System.out.println(list1.remove("Py"));
		System.out.println("Cur List: "+list1);
		
		System.out.println(list1.set(3, "Py"));
		System.out.println("Cur List: "+list1);
	}

}
