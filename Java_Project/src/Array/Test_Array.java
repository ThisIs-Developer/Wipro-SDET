package Array;

public class Test_Array {
	public static void main(String[] args) {
		
		
		
//		int[] arr = {1,2,3,4,5};
//		for(int i=0;i<arr.length;i++) {
//			for(int j=0;j<arr[i];j++) {
//				System.out.print(arr[j]);
//			}
//			System.out.println();
//		}
		
//		int[][] arr = new int[5][5];
//		for(int i=0;i<arr.length;i++) {
//			for(int j=0;j<i;j++) {
//				System.out.print(arr[i][j]+" ");
//				arr[i][j]=j+1;
//				System.out.print(arr[i][j]);
//			}
//			System.out.println();
//		}
		
//		int n = 10;
//		int[] arr = new int[n];
//		
//		arr[0]=0;
//		arr[1]=1;
//		
//		for(int i=2;i<n;i++) {
//			arr[i]=arr[i-1]+arr[i-2];
//		}
//		for( int i=0; i<n;i++) {
//			System.out.print(arr[i]+ "  ");
//		}
		
		
		int[][][] arr= {{{10,20},{30,40}},//ref0
			       {{50,60,70},{80,90}}};//ref1
	
		//System.out.println(arr[1][0][2]);
		for(int i=0;i<arr.length;i++)// ref
		{
			for(int j=0;j<arr[i].length;j++)
			{
				for(int k=0;k<arr[i][j].length;k++)
				{
					System.out.print(arr[i][j][k]+" | ");
				}
				System.out.println();
			}
			System.out.println();
		}
		
	}

}
