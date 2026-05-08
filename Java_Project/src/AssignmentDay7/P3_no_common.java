package AssignmentDay7;
import java.util.*;
public class P3_no_common {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashSet<Integer> s1 = new HashSet<>();
		s1.add(9);
		s1.add(13);
		s1.add(19);
		s1.add(19);		
		HashSet<Integer> s2 = new HashSet<>();
		s2.add(10);
		s2.add(15);
		s2.add(17);
		s2.add(19);	
		HashSet<Integer> temp = new HashSet<>();
        temp.addAll(s1);
        temp.addAll(s2);
        s1.retainAll(s2);
        temp.removeAll(s1);
        System.out.println("Unique Value: "+temp);
	}
}
