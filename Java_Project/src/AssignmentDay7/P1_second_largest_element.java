package AssignmentDay7;
import java.util.*;
public class P1_second_largest_element {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> list = new ArrayList<>();
		list.add(9);
		list.add(13);
		list.add(19);
		list.add(19);		
		Collections.sort(list);
		if (list.size() < 2) {
            System.out.println("No second largest element1");
            return;
        }
		int l=list.get(list.size()-1);
        Integer sl=null;
        for (int i=list.size()-2;i>=0;i--) {
            if (list.get(i)!=l) {
                sl=list.get(i);
                break;
            }
        }
        if (sl==null) {
            System.out.println("No second largest element2");
        } else {
            System.out.println("Second Largest: " +sl);
        }        
    }

}
