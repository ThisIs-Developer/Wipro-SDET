package AssignmentDay8;
import java.util.HashMap;
public class P1_non_repeating_char {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<Character,Integer>map=new HashMap<>();
		String str ="Baivab";
		for(char ch:str.toCharArray()) {
			map.put(ch, map.getOrDefault(ch, 0) + 1);
		}
		System.out.println(map);
		for (char ch:str.toCharArray()) {
            if(map.get(ch)==1) {
                System.out.println("first non-repeating: "+ch);
                break;
            }
        }
	}
}
