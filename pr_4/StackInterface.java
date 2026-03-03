interface Stack {
    int size = 5; 
    void push(int value);
    void pop();
    void display();
    void overflow();
    void underflow();
}
class IntegerStack implements Stack {
    int[] arr = new int[size];
    int top = -1;
    public void push(int value) {
        if (top == size - 1) {
            overflow();
        } else {
            arr[++top] = value;
            System.out.println(value + " pushed into stack.");
        }
    }
    public void pop() {
        if (top == -1) {
            underflow();
        } else {
            System.out.println(arr[top--] + " popped from stack.");
        }
    }
    public void display() {
        if (top == -1) {
            System.out.println("Stack is empty.");
        } else {
            System.out.println("Stack elements:");
            for (int i = top; i >= 0; i--) {
                System.out.println(arr[i]);
            }
        }
    }
    public void overflow() {
        System.out.println("Stack Overflow! Cannot push element.");
    }
    public void underflow() {
        System.out.println("Stack Underflow! Cannot pop element.");
    }
}
public class StackInterface {
    public static void main(String[] args) {
        IntegerStack stack = new IntegerStack();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.push(50);
        stack.push(60);  // Overflow
        System.out.println();
        stack.display();
        System.out.println();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();  // Underflow
        System.out.println();
        stack.display();
    }
}