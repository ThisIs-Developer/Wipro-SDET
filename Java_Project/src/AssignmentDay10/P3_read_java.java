package AssignmentDay10;
import java.io.*;
public class P3_read_java {
    public static void main(String[] args) throws IOException {
        File file = new File("src/AssignmentDay10/P3.txt");
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
            bw.write("Hello World Java SDET 2026");
            bw.newLine();
            bw.write("Assignment Question, Testing");
        }
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.toLowerCase().contains("java")) {
                    System.out.println(line);
                }
            }
        }
    }
}