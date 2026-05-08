package IOPackage;
import java.io.File;
import java.io.IOException;

public class File_Create {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		File file = new File("src/IOPackage/Demo.txt");
		file.createNewFile();
	}

}
