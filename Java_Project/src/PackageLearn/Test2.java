package PackageLearn;

public class Test2 {

    public static void main(String[] args) {
    	Test1 t1 = new Test1();
//        System.out.println("Private: " + t1.a);
        System.out.println("Private: " + t1.getA());
    	System.out.println("Default: "+t1.b);
    	System.out.println("Protected: "+t1.c);
        System.out.println("Public: " + t1.d);
    }
}
