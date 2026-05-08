package Collection;
import java.util.*;
public class LinkHasSet_Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedHashSet<String> s = new LinkedHashSet<String>();
		LinkedHashSet<String> s1 = new LinkedHashSet<String>();
		LinkedHashSet<String> s2 = new LinkedHashSet<String>();
		s.add("C");
		s.add("CPP");
		s.add(null);
		s.add("C");
		s.add("Java");
		s.add("Py");
		s.add(null);
		System.out.println(s);
		
//		s1.add("Java");
		s1.add(null);
		s2.add("Java");
		System.out.println(s1.equals(s2));
		
		System.out.println(s.remove("Py"));
		System.out.println(s);
		
		System.out.println(s1.isEmpty());
		
		Iterator<String> itr = s.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
		
	}

}
