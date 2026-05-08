package IOPackage;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class P6_largest_word {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		File file = new File("src/IOPackage/P1.txt");
		file.createNewFile();
		
		BufferedWriter bw = new BufferedWriter(new FileWriter("src/IOPackage/P1.txt"));
		bw.write("Heelo Pythonnnnnn, Python is goood, Python Python ");
		bw.write("\nHeelo Python, Python is goood, Python Python ");
//		bw.write("\nHeelo Python, Python is goood, Python Python ");
		bw.close();
					
		BufferedReader br = new BufferedReader(new FileReader ("src/IOPackage/P1.txt"));
		String str;
        String largest = "";
        while ((str = br.readLine()) != null) {
            String[] words = str.split(" ");
            for (String word : words) {
                word = word.replaceAll("[^a-zA-Z0-9]", "");
                if (word.length() > largest.length()) {
                    largest = word;
                }
            }
        }
        br.close();
        System.out.println("Largest word: " + largest);
	}

}
