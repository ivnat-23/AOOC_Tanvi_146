import java.util.Scanner;

public class FactorialProgram {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int num = sc.nextInt();

        int factorial = 1;

        if (num < 0) {
            System.out.println("Factorial does not exist for negative numbers.");
        } else {
            for (int i = 1; i <= num; i++) {
                factorial = factorial * i;
            }
            System.out.println("Factorial of " + num + " is: " + factorial);
        }

        sc.close();
    }
}