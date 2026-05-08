package AssignmentDay11;

import java.util.Map;
import java.util.TreeMap;

public class P4_sort_map {
	public static void main(String[] args) {
        Map<Integer, String> map = new TreeMap<>();
        map.put(3, "C");
        map.put(1, "A");
        map.put(2, "B");
        for (Integer key:map.keySet()) {
            System.out.println(key+": "+map.get(key));
        }
    }
}
