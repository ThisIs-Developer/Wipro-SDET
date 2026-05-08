package String;

public class Test_String {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str1="Hello";
		String str2=new String("World");

//		System.out.println(str1);
//		System.out.println(str2);
		
//		str1.concat(" "+str2); // str1=str1.concat(" "+str2);
//		System.out.println(str1);
	
//		String strNew = str1.concat(" "+str2);
//		System.out.println(strNew);

		StringBuffer sb1 =new StringBuffer("Hello");
		StringBuffer sb2 = new StringBuffer("World");
	
//		sb1.append(str2);
//		System.out.println(" "+sb1);
		
		System.out.println(sb2.charAt(2));
//		System.out.println(sb1.indexOf('H'));
		System.out.println(sb1.codePointAt(0));
		System.out.println(sb1.codePointBefore(3));
//		System.out.println(sb1.compareTo(str1));
		System.out.println(str1.compareToIgnoreCase(str2));
	}

}
