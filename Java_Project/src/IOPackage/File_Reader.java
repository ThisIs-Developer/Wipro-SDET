package IOPackage;

import java.io.FileReader;
import java.io.IOException;

public class File_Reader {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		FileReader reader = new FileReader("src/IOPackage/Demo.txt");
        int data;
        while ((data = reader.read()) != -1) {
            System.out.print((char) data);
        }
        reader.close();

	}

}
