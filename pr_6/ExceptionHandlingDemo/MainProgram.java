package ExceptionHandlingDemo;
import java.util.Scanner;
public class MainProgram {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Calculator calc = new Calculator();
        System.out.print("Enter first number: ");
        int a = sc.nextInt();
        System.out.print("Enter second number: ");
        int b = sc.nextInt();
        try {
            int result = calc.divide(a, b);
            System.out.println("Result: " + result);
        } 
        catch (DivisionException e) {
            System.out.println("Error: " + e.getMessage());
        }
        System.out.println("Program continues without crashing...");
        sc.close();
    }
}