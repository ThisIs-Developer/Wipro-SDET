package AssignmentDay8;
import java.util.*;
public class P2_shopping {
	public static void main(String[] args) {
		ArrayList<String> arr=new ArrayList<String>();
		arr.add("Butter");
		arr.add("Egg");
		arr.add("Rice");
		arr.add("Egg");
		HashMap<String,Double> map= new HashMap<String,Double>();
		map.put("Rice", 55.6);
		map.put("Egg", 7.50);
		map.put("Plastic Bag", null);
		map.put("Butter", 50.0);
		System.out.println("My cart: "+arr);
		System.out.println("Product price: "+map);
	}
}
