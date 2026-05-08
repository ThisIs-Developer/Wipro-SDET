package IOPackage;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

//count number of words from para
public class P3_count_word {

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
			String str;
			int count1=0;
			while((str=br.readLine())!=null) {
				String[] count=str.split(" ");
				count1 = count1+count.length;
			}
			System.out.println(count1);
		}

	}

}
