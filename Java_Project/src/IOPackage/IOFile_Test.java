package IOPackage;
import java.io.*;
import java.util.Scanner;
public class IOFile_Test {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		File file = new File("src/IOPackage/User.txt");
		System.out.println(file);
		Scanner sc = new Scanner(file);
		//read all
		while(sc.hasNextLine()) {
			System.out.println(sc.nextLine());
		}
		// one file
//		System.out.println(sc.nextLine());
		sc.close();
	}

}
