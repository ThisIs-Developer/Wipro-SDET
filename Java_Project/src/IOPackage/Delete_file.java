package IOPackage;
 
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
 
public class Delete_file {
 
	public static void main(String[] args) throws IOException {
		File file=new File("src/IOPackage/Delete.txt");
		if(file.createNewFile())
		{
			System.out.println("File created successfully");
		}
		else
		{
			System.out.println("Unable to create file");
		}
		 FileWriter wr=new FileWriter("src/IOPackage/Delete.txt");
	        wr.write("Let's learn JAva Prgraming\n, Selenium Automation\n");// override  line
	       // wr.write("");
	        wr.close();
		FileReader reader = new FileReader("src/IOPackage/Delete.txt");
        int data;
        while ((data = reader.read()) != -1) {
            System.out.print((char) data);
        }
        reader.close();
		
		if(file.delete())
		{
			System.out.println("File deleted");
		}
		else
		{
			System.out.println("Failed to delete");
		}
		if(file.exists())
		{
			System.out.println(file);
		}
		else
			System.out.println("File not found");
 
	}
 
}
 
 