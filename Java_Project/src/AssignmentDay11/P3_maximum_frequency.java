package AssignmentDay11;

public class P3_maximum_frequency {
	public static void main(String[] args) {
        int[] arr = {1,2,2,3,3,3,4};
        int maxCount=0;
        int maxElement= arr[0];
        for (int i=0; i<arr.length; i++) {
            int count = 0;
            for (int j=0; j<arr.length; j++) {
                if (arr[i]==arr[j]) {
                    count++;
                }
            }
            if (count >maxCount) {
                maxCount=count;
                maxElement =arr[i];
            }
        }
        System.out.println(maxElement);
    }
}