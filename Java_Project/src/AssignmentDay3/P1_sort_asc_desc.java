package AssignmentDay3;
import java.util.Scanner;

public class P1_sort_asc_desc {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size: ");
        int N = sc.nextInt();
        int[] arr = new int[N];
        int[] asc = new int[N];
        int[] desc = new int[N];
        System.out.print("Enter number: ");
        for(int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
            asc[i] = arr[i];
            desc[i] = arr[i];
        }
        for(int i=0;i<N-1; i++) {
            for(int j=0;j<N-i-1;j++) {
                if(asc[j]>asc[j+1]) {
                    int temp =asc[j];
                    asc[j]=asc[j + 1];
                    asc[j+1]=temp; }
            }
        }
        for(int i=0;i<N-1; i++) {
        	for(int j=0;j<N-i-1;j++) {
                if(desc[j]<desc[j+1]) {
                    int temp=desc[j];
                    desc[j]=desc[j + 1];
                    desc[j+1]=temp; }
            }
        }
        System.out.print("Asc: ");
        for(int i=0;i<N;i++) {
            System.out.print(asc[i]+" ");
        }
        System.out.println();
        System.out.print("Desc: ");
        for(int i=0;i<N;i++) {
            System.out.print(desc[i]+" ");
        }
        sc.close();
    }
}