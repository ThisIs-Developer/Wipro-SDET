package AssignmentDay3;

import java.util.Scanner;
public class P4_palindrom_arr {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        System.out.print("Enter array size: ");
        int N = sc.nextInt();
        int[] arr = new int[N];
        System.out.print("Enter array items: ");
        for(int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        boolean pali = true;

        for(int i=0; i<N/2;i++) {
            if(arr[i]!=arr[N-1-i]) {
                pali = false;
                break; }
        }

        if(pali) {
            System.out.println("Palindrome");
        } else {
            System.out.println("Not Palindrome");
        }
        sc.close();
	}
}
