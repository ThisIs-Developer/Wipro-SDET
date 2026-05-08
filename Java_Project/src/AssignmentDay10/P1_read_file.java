package AssignmentDay10;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class P1_read_file {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		File file = new File("src/AssignmentDay10/P1.txt");
		file.createNewFile();
		
		BufferedWriter bw = new BufferedWriter(new FileWriter(file));
		bw.write("Heelo Wirp java SDET 2026");
		bw.write("\nAssignment Question, Tesing");
		bw.close();
					
		try (BufferedReader br = new BufferedReader(new FileReader (file))) {
			int count=0;
			while(br.readLine()!=null) {
				count++;
			}
			System.out.println("Totall line: "+count);
		}
		try (BufferedReader br = new BufferedReader(new FileReader (file))) {
			String str;
			int count1=0;
			while((str=br.readLine())!=null) {
				String[] count=str.split(" ");
				count1 = count1+count.length;
			}
			System.out.println("total word: "+count1);
		}
		try (BufferedReader br = new BufferedReader(new FileReader (file))) {
			int count=0;
			while((br.read())!=-1) {
				count++;
			}
			System.out.println("total character: "+count);
		}
	}

}
