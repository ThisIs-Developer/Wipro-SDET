package Variable;

public class SafeConversion {
    public static void main(String[] args) {
        double d = 10.5;
//        int num = (int)d;
//        System.out.println(num);

        if (d == (int) d) {
            int num = (int) d;
            System.out.println("Converted: " + num);
        } else {
            System.out.println("Data loss will occur!");
        }
    }
}