package IOPackage;
//write a program to count number of lines

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class P1_count_line {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		File file = new File("src/IOPackage/P1.txt");
		file.createNewFile();
		
		BufferedWriter bw = new BufferedWriter(new FileWriter("src/IOPackage/P1.txt"));
		bw.write("Heelo Python, Python is goood, Python Python ");
		bw.write("\nHeelo Python, Python is goood, Python Python ");
//		bw.write("\nHeelo Python, Python is goood, Python Python ");
		bw.close();
					
		try (BufferedReader br = new BufferedReader(new FileReader ("src/IOPackage/P1.txt"))) {
			int count=0;
			while(br.readLine()!=null) {
				count++;
			}
			System.out.println(count);
		}
		
	}

}
