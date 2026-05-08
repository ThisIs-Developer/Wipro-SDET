package AssignmentDay10;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class P2_append_data {
	public static void main(String[] args) throws IOException {
		File file = new File("src/AssignmentDay10/P2.txt");
	
	    try (Scanner sc = new Scanner(System.in);
	         BufferedWriter bw = new BufferedWriter(new FileWriter(file, true))) {
	        System.out.print("Enter text: ");
	        String input = sc.nextLine();
	        bw.newLine();
	        bw.write(input);
	        System.out.println("Data added");
	    }
	}
}
