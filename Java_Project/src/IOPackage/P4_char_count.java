package IOPackage;
//count number of characters from line
import java.io.*;

public class P4_char_count {

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
			while((br.read())!=-1) {
				count++;
			}
			System.out.println(count);
		}
	}

}
