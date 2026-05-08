package IOPackage;
//copy text from one file to another
import java.io.*;

public class P5_copy_text {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("src/IOPackage/P1.txt"));
        File file=new File("src/IOPackage/P5.txt");
        file.createNewFile();
        BufferedWriter copy = new BufferedWriter(new FileWriter(file));
        String str;
        while ((str=br.readLine()) != null) {
            System.out.println("P1 txt: "+str);
            copy.write(str);
        }
        br.close();
        copy.close();

        BufferedReader br1 = new BufferedReader(new FileReader(file));
        String str2;
        while ((str2= br1.readLine()) != null) {
            System.out.println("P5 txt: "+str2);
        }
        br1.close();
    }
}