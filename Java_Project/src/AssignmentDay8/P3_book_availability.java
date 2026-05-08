package AssignmentDay8;
import java.util.*;
public class P3_book_availability {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeMap<String,Boolean> map= new TreeMap<String,Boolean>();
		map.put("Harry Potter 1", true);
		map.put("Harry Potter 5", false);
		map.put("Harry Potter 3", false);
		map.put("Harry Potter 2", true);
		map.put("Harry Potter 4", false);
		String user1 = "Harry Potter 2";
        if (!map.containsKey(user1)) {
            System.out.println("No book found");
        } 
        else if (map.get(user1)) {
            System.out.println("available");
        } 
        else {
            System.out.println("Not available");
        }

	}

}
