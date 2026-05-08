package AssignmentDay3;
import java.util.Scanner;

public class P2_duplicate_items {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter array size: ");
        int N = sc.nextInt();
        int[] arr = new int[N];
        System.out.print("Enter array items: ");
        for(int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        for(int i = 0; i < N; i++) {
            boolean dup = false;
            for(int j = 0; j < i; j++) {
                if(arr[i] == arr[j]) {
                    dup = true;
                    break;
                }
            }
            if(!dup) {
                System.out.print(arr[i] + " ");
            }
        }
        sc.close();
    }
}