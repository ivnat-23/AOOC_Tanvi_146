class OddNumberException extends Exception {
    public OddNumberException(String message) {
        super(message);
    }
}
public class OddNumberCheck {
    public static void checkNumber(int num) throws OddNumberException {
        if (num % 2 != 0) {
            throw new OddNumberException("Number is odd: " + num);
        } else {
            System.out.println("Number is even: " + num);
        }
    }
    public static void main(String[] args) {
        int number = 7;   // You can change this value
        try {
            checkNumber(number);
        } catch (OddNumberException e) {
            System.out.println("Exception Caught: " + e.getMessage());
        }
        System.out.println("Program continues...");
    }
}