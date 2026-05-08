// Main public class (must match file name)
package AssignmentDay4;


public class P1_moveable_shapes {

    public static void main(String[] args) {
        MovablePoint point = new MovablePoint(0, 0, 1, 1);
        MovableCircle circle = new MovableCircle(5, new MovablePoint(10, 10, 2, 2));
        MovableRectangle rectangle = new MovableRectangle(
                new MovablePoint(0, 0, 1, 1),
                new MovablePoint(5, 5, 1, 1)
        );

        System.out.println("Initial positions:");
        System.out.println(point);
        System.out.println(circle);
        System.out.println(rectangle);

        System.out.println("\nAfter moving right:");
        point.moveRight();
        circle.moveRight();
        rectangle.moveRight();

        System.out.println(point);
        System.out.println(circle);
        System.out.println(rectangle);
    }
}

// Remove public from all below

interface Movable {
    void moveUp();
    void moveDown();
    void moveLeft();
    void moveRight();
}

class MovablePoint implements Movable {
    private int x, y;
    private int xSpeed, ySpeed;

    public MovablePoint(int x, int y, int xSpeed, int ySpeed) {
        this.x = x;
        this.y = y;
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public void moveUp() { y -= ySpeed; }
    public void moveDown() { y += ySpeed; }
    public void moveLeft() { x -= xSpeed; }
    public void moveRight() { x += xSpeed; }

    public int getX() { return x; }
    public int getY() { return y; }
    public int getXSpeed() { return xSpeed; }
    public int getYSpeed() { return ySpeed; }

    public String toString() {
        return String.format("Point(%d, %d) speed(%d, %d)", x, y, xSpeed, ySpeed);
    }
}

class MovableCircle implements Movable {
    private int radius;
    private MovablePoint center;

    public MovableCircle(int radius, MovablePoint center) {
        this.radius = radius;
        this.center = center;
    }

    public void moveUp() { center.moveUp(); }
    public void moveDown() { center.moveDown(); }
    public void moveLeft() { center.moveLeft(); }
    public void moveRight() { center.moveRight(); }

    public String toString() {
        return String.format("Circle(radius=%d, center=%s)", radius, center);
    }
}

class MovableRectangle implements Movable {
    private MovablePoint topLeft;
    private MovablePoint bottomRight;

    public MovableRectangle(MovablePoint topLeft, MovablePoint bottomRight) {
        if (topLeft.getXSpeed() != bottomRight.getXSpeed() ||
            topLeft.getYSpeed() != bottomRight.getYSpeed()) {
            throw new IllegalArgumentException("Both points must have same speed");
        }
        this.topLeft = topLeft;
        this.bottomRight = bottomRight;
    }

    public void moveUp() { topLeft.moveUp(); bottomRight.moveUp(); }
    public void moveDown() { topLeft.moveDown(); bottomRight.moveDown(); }
    public void moveLeft() { topLeft.moveLeft(); bottomRight.moveLeft(); }
    public void moveRight() { topLeft.moveRight(); bottomRight.moveRight(); }

    public String toString() {
        return String.format("Rectangle(topLeft=%s, bottomRight=%s)", topLeft, bottomRight);
    }
}

// Optional: also non-public
interface Polygon {
    double getArea();

    default double getPerimeter(int... sides) {
        double perimeter = 0;
        for (int side : sides) perimeter += side;
        return perimeter;
    }

    static String shapeInfo() {
        return "Polygon: A shape with straight sides";
    }
}