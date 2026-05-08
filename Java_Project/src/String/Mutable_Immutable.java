package String;

public class Mutable_Immutable {

	public static void main(String[] args) {
		// Immutable String
		String str1 = "Hello world";
		System.out.println(str1);
		System.out.println(str1.charAt(2));
		System.out.println(str1.concat(" Hi"));
		
		// Convert Immutable to Mutable String
		StringBuffer sb = new StringBuffer(str1);
		System.out.println(sb);
		sb.append(" RIP");
		System.out.println(sb);
		
		// Convert Mutable to Immutable String
		String str2 = new String("Happy");
		str2.concat(" Coding");
		System.out.println(str2);
		System.out.println(str2.concat(" Coding"));
		System.out.println(str2);
		
	}

}
