package AssignmentDay3;

import java.util.Scanner;
public class P3_largest_2D {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        System.out.print("Enter array size: ");
        int N = sc.nextInt();
        int[] arr = new int[N];
        System.out.print("Enter array items: ");
        for(int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        int lar = 0;
        for(int i=0;i<N;i++) {
        	if(lar<arr[i])
        	{
        		lar=arr[i];
        	}
        }
        System.out.println("largest numebr in array: "+lar);
        sc.close();
	}
}
