package AssignmentDay6;
class Box {
    int length;
}
public class P2_modifiy_byObj {
    static void Modi(Box b) {
        b.length=50;
    }
    public static void main(String[] args) {
        Box b=new Box();
        b.length=10;
        System.out.println("Before: "+b.length);
        Modi(b);
        System.out.println("After: "+b.length);
    }
}