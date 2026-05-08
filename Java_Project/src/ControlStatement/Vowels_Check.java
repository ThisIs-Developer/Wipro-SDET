package ControlStatement;

public class Vowels_Check {

    public static void main(String[] args) {
        char ch = 's';

        if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' ||
        	    ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U') {
            System.out.println("It is a vowel");
        } else {
            System.out.println("It is a consonant");
        }
    }
}