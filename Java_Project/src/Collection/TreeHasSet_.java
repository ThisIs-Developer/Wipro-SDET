package Collection;
import java.util.*;
public class TreeHasSet_ {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeSet<String> s = new TreeSet<String>();
		TreeSet<String> s1 = new TreeSet<String>();
		TreeSet<String> s2 = new TreeSet<String>();
		s.add("C");
		s.add("CPP");
		s.add("C");
		s.add("Java");
		s.add("Py");
		System.out.println(s);
		
//		s1.add("Java");
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
