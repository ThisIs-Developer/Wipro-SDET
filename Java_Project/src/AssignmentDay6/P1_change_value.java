package AssignmentDay6;
public class P1_change_value {
	static void Sum(int num) {
        num =num+10;
        System.out.println("sum="+num);
    }
    public static void main(String[] args) {
        int num=5;
        System.out.println("before: "+num);
        Sum(num);
        System.out.println("After: "+num);
    }
}
