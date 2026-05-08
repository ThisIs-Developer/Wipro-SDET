package AssignmentDay10;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class P4_count_word {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		File file = new File("src/AssignmentDay10/P3.txt");
        int count = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] words = line.split("\\W+");
                for (String word : words) {
                    if (word.equalsIgnoreCase("Java")) {
                        count++;
                    }
                }
            }
            System.out.println("Total Java: "+count);
        }
	}
}
