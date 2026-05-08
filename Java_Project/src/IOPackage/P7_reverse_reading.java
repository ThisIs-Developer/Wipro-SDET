package IOPackage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class P7_reverse_reading {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		File file = new File("src/IOPackage/P1.txt");
		file.createNewFile();
		
		BufferedWriter bw = new BufferedWriter(new FileWriter("src/IOPackage/P1.txt"));
		bw.write("Heelo Pythonnnnnn, Python is goood, Python Python ");
		bw.write("\nHeelo Python, Python is goood, Python Python ");
//		bw.write("\nHeelo Python, Python is goood, Python Python ");
		bw.close();
	}

}
