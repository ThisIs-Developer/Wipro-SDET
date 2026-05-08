/*
 * String Length You have a string S. You should choose any two characters and delete 
 * all of their occurrences in the string. Return the minimum length of S possible after 
 * the given operations. Function Description: In the provided code snippet, implement 
 * the provided minLength(...) method to return the minimum length of S possible after 
 * performing the given operations. You can write your code in the space below the phrase 
 * “WRITE YOUR LOGIC HERE”. There will be multiple test cases running so the Input and 
 * Output should match exactly as provided. Input Format: The only line contains string S. 
 * Output Format: The output contains an integer denoting the minimum length of S possible 
 * after the given operations. Constraints: 1 ≤ S.length ≤ 10^5. 1 ≤ S.length ≤ 10^5. 
 * Sample Input 1: aaabb -- denotes the string S Sample Output 1: 0 Explanation 1: 
 * Here, choosing "a" and "b" will delete all the characters in the string. We will be 
 * left with an empty string. Hence, the length of string S will be 0. 
 * Sample Input 2: aaabbjadkja -- denotes the string S Sample Output 2: 4 Explanation 2: 
 * Here, choosing "a" and "b"/ "j" will delete all the respective characters in the string. 
 * We will be left with "jdkj" if we delete 'a' and 'b' or we will be left with "bbdk" if 
 * we delete 'a' and 'j'. Hence, the length of string S will be 4.
 */
package AssignmentDay9;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Auto_mini_length {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter a string: ");
		String str = sc.nextLine();
		sc.close();
		Map<Character, Integer> hm = new HashMap<Character, Integer>();
		for(char ch:str.toCharArray()) {
			hm.put(ch, hm.getOrDefault(ch, 0)+1);
		}
		System.out.println(hm);
		int str1=0, str2=0;
		for (int freq : hm.values()) {
            if (freq > str1) {
                str2 = str1;
                str1 = freq;
            } else if (freq > str2) {
                str2 = freq;
            }
        }
		System.out.println(str.length() - (str1 + str2));

	}

}
