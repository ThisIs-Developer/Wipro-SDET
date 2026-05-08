package IOPackage;
import java.io.*;
public class Replace_Word {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		File file = new File("src/IOPackage/Replace.txt");
		file.createNewFile();
		
		BufferedWriter bw = new BufferedWriter(new FileWriter("src/IOPackage/Replace.txt"));
		bw.write("Heelo Python, Python is goood, Python Python ");
		bw.write("\nHeelo Python, Python is goood, Python Python ");
		bw.close();
		
		try (BufferedReader br = new BufferedReader(new FileReader("src/IOPackage/Replace.txt"))) {
			String str;
			while((str=br.readLine())!=null) {
				System.out.println(str);
			}
			
			//Up
			BufferedReader br1 = new BufferedReader(new FileReader(file));
			while ((str = br1.readLine()) != null) {
			    str = str.replace("Python", "Java");
			    System.out.println(str);
			}
			br1.close();
		}
		
	}

}
