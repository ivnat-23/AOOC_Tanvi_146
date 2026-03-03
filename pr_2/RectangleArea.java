import java.util.Scanner;

class Area {

    private double length;
    private double breadth;

    // Method to set dimensions
    public void setDim(double length, double breadth) {
        this.length = length;
        this.breadth = breadth;
    }

    // Method to calculate and return area
    public double getArea() {
        return length * breadth;
    }
}

public class RectangleArea {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Create object of Area class
        Area rectangle = new Area();

        // Taking input from keyboard
        System.out.print("Enter length: ");
        double length = sc.nextDouble();

        System.out.print("Enter breadth: ");
        double breadth = sc.nextDouble();

        // Set dimensions
        rectangle.setDim(length, breadth);

        // Display area
        System.out.println("Area of Rectangle: " + rectangle.getArea());

        sc.close();
    }
}