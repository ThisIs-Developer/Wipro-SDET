package IOPackage;
import java.io.*;

public class BufferedReader_Test {

	public static void main(String[] args) throws IOException {
		
		// Create file
		File file = new File("src/IOPackage/Hello.txt");
		file.createNewFile();
		
		// Write File
		BufferedWriter bw= new BufferedWriter(new FileWriter ("src/IOPackage/Hello.txt"));
		bw.write("Hello Baivab");
		bw.close();
		
		try (// Read File
		BufferedReader br = new BufferedReader(new FileReader ("src/IOPackage/Hello.txt"))) {
			String str;
			while((str=br.readLine())!=null) {
				System.out.println(str);
			}
//		System.out.println(str=br.readLine());
		}

	}

}
