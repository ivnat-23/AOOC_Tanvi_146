import MathOperations.FloorOperation;
import MathOperations.RoundOperation;
import MathOperations.CeilOperation;
public class Math {
    public static void main(String[] args) {
        double number = 10.6;
        FloorOperation floorObj = new FloorOperation();
        RoundOperation roundObj = new RoundOperation();
        CeilOperation ceilObj = new CeilOperation();
        System.out.println("Original Number: " + number);
        System.out.println("Floor Value: " + floorObj.getFloor(number));
        System.out.println("Round Value: " + roundObj.getRound(number));
        System.out.println("Ceil Value: " + ceilObj.getCeil(number));
    }
}