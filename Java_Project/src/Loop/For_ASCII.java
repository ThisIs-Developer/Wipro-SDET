package Loop;

public class For_ASCII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Method 1
//		char i;
//		for(i='A'; i<='Z';i++) {
//			int vl = (int)i;
//			System.out.println(i+": "+vl);
//		}
//		Method 2
//		for(int i='A';i<='Z';i++) {
//			System.out.println((char)i+":"+i);
//		}
//		Method 3
		for(char i='A';i<='Z';i++){
			System.out.println(i+":"+(i+0));
		}
	}

}
