package AssignmentDay1;

//import java.util.Scanner;
public class P6_vowel_consonant {

	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//        System.out.print("Enter a character: ");
        char ch = 'e';
        if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' ||
        	    ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U') {
            System.out.println("It is a vowel");
        } else {
            System.out.println("It is a consonant");
        }

	}

}
