interface Shape {
    double area();   // abstract method
}
class Rectangle implements Shape {
    double length;
    double breadth;
    Rectangle(double length, double breadth) {
        this.length = length;
        this.breadth = breadth;
    }
    public double area() {
        return length * breadth;
    }
}
class Triangle implements Shape {
    double base;
    double height;
    Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }
    public double area() {
        return 0.5 * base * height;
    }
}
public class ShapeInterface {
    public static void main(String[] args) {
        Rectangle rect = new Rectangle(10, 5);
        Triangle tri = new Triangle(6, 4);
        System.out.println("Area of Rectangle: " + rect.area());
        System.out.println("Area of Triangle: " + tri.area());
    }
}