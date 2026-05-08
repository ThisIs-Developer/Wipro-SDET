package IOPackage;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class File_Writter {

	public static void main(String[] args) throws IOException {
		try (// TODO Auto-generated method stub
		FileWriter w = new FileWriter("src/IOPackage/Demo.txt")) {
			w.write("Heelooo Guys");
		}
		File file = new File("src/IOPackage/Demo.txt");
		try (Scanner sc = new Scanner(file)) {
			//read all
			while(sc.hasNextLine()) {
				System.out.println(sc.nextLine());
			}
		}
	}

}
