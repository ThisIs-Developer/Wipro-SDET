package Map;
import java.util.*;

public class LinkedHashMap_Test {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedHashMap<String, Integer> map = new LinkedHashMap<String, Integer>();
		map.put("Five", 5);
		map.put("One", 1);
		map.put(null, null);
		map.put(null, 100);
		map.put("Other1", null);
		map.put("Other2", 5);
		
		System.out.println("Cur Map: "+map);
		System.out.println("Key = Value: " +map.containsKey(null));
		System.out.println("Key = Value: " +map.containsKey("One"));
		System.out.println("Value = Key: " +map.containsValue(null));
		System.out.println("Value = Key: " +map.containsValue(100));
		
		System.out.println("Cur Map: "+map);
		System.out.println(map.replace("Other2", 5, 15));
		System.out.println("Cur Map: "+map);
		System.out.println(map.replace("Other2", 25));
		System.out.println("Cur Map: "+map);
		
		System.out.println(map.get("Other1"));
		System.out.println(map.get("Other2"));
				
		LinkedHashMap<String, Integer> map1 = new LinkedHashMap<String, Integer>();
		map1=(LinkedHashMap<String, Integer>) map.clone();
		
		map.clear();
		
		System.out.println(map);
		System.out.println(map1);
	}

}
