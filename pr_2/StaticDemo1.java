class StaticDemo {
    // Static variable
    static int count;
    // Static block
    static {
        count = 100;
        System.out.println("Static Block Executed");
        System.out.println("Initial count value: " + count);
    }
    // Static method
    static void showCount() {
        System.out.println("Static Method Called");
        System.out.println("Count value: " + count);
    }
    // Constructor
    StaticDemo() {
        count++;
        System.out.println("Constructor Called. Count increased.");
    }
}
public class StaticDemo1 {
    public static void main(String[] args) {
        System.out.println("Main Method Started");
        StaticDemo obj1 = new StaticDemo();
        StaticDemo obj2 = new StaticDemo();

        StaticDemo.showCount();   // Calling static method
    }
}