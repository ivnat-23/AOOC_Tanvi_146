abstract class Shape {
    double dim1;
    double dim2;
    Shape(double dim1, double dim2) {
        this.dim1 = dim1;
        this.dim2 = dim2;
    }
    abstract double area();
}
class Rectangle extends Shape {
    Rectangle(double length, double breadth) {
        super(length, breadth);
    }
    double area() {
        return dim1 * dim2;
    }
}
class Triangle extends Shape {
    Triangle(double base, double height) {
        super(base, height);
    }
    double area() {
        return 0.5 * dim1 * dim2;
    }
}
public class ShapeDemo {
    public static void main(String[] args) {
        Rectangle rect = new Rectangle(10, 5);
        Triangle tri = new Triangle(6, 4);
        System.out.println("Area of Rectangle: " + rect.area());
        System.out.println("Area of Triangle: " + tri.area());
    }
}