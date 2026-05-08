package AssignmentDay4;
interface PolygonShape {
	double getArea();
    default double getPerimeter(int... sides) {
        double sum = 0;
//        int len=sides.length;
//        for (int i=0; i<len; i++) {
//            sum =sum+i;
//        }
        for(int i:sides) {
        	sum+=i;
        }
        return sum;
    }
    static String shapeInfo() {
        return "Polygons shape";
    }
}
class Rectangle implements PolygonShape {
    int length,width;
    Rectangle(int length,int width) {
        this.length =length;
        this.width =width;
    }
    public double getArea() {
        return length* width;
    }
}
class Triangle implements PolygonShape {
    int base, height;
    Triangle(int base,int height) {
        this.base=base;
        this.height=height;
    }
    public double getArea() {
        return 0.5*base*height;
    }
}
public class P2_polygon {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Rectangle r = new Rectangle(10, 5);
        System.out.println("Rectangle Area: " + r.getArea());
        
        System.out.println("Rectangle Perimeter: " + 
            r.getPerimeter(10, 5, 10, 5));

        Triangle t = new Triangle(6, 4);
        System.out.println("Triangle Area: " + t.getArea());
        
        System.out.println("Triangle Perimeter: " + 
            t.getPerimeter(3, 4, 5));
        System.out.println(Polygon.shapeInfo());
	}

}
