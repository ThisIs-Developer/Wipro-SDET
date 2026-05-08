package AssignmentDay2;

public class P2_vowel_consonant_switch {

	public static void main(String[] args) {
		char ch = 'e';
		switch (ch) {
	        case 'a':
	        case 'e':
	        case 'i':
	        case 'o':
	        case 'u':
	        case 'A':
	        case 'E':
	        case 'I':
	        case 'O':
	        case 'U':
	            System.out.println("vowel");
	            break;
	        default:
	            System.out.println("Consonant");
		}
	}

}
