import java.util.Scanner;
class Stack {
    int top;
    int maxSize;
    int[] arr;
    Stack(int size) {
        maxSize = size;
        arr = new int[maxSize];
        top = -1;
    }
    void push(int value) {
        if (top == maxSize - 1) {
            System.out.println("Stack Overflow");
        } else {
            arr[++top] = value;
            System.out.println(value + " pushed into Stack");
        }
    }
    void pop() {
        if (top == -1) {
            System.out.println("Stack Underflow");
        } else {
            System.out.println(arr[top--] + " popped from Stack");
        }
    }
    void display() {
        if (top == -1) {
            System.out.println("Stack is Empty");
        } else {
            System.out.println("Stack Elements:");
            for (int i = top; i >= 0; i--) {
                System.out.println(arr[i]);
            }
        }
    }
}
class Queue {
    int front, rear, maxSize;
    int[] arr;
    Queue(int size) {
        maxSize = size;
        arr = new int[maxSize];
        front = 0;
        rear = -1;
    }
    void enqueue(int value) {
        if (rear == maxSize - 1) {
            System.out.println("Queue Overflow");
        } else {
            arr[++rear] = value;
            System.out.println(value + " inserted into Queue");
        }
    }
    void dequeue() {
        if (front > rear) {
            System.out.println("Queue Underflow");
        } else {
            System.out.println(arr[front++] + " removed from Queue");
        }
    }
    void display() {
        if (front > rear) {
            System.out.println("Queue is Empty");
        } else {
            System.out.println("Queue Elements:");
            for (int i = front; i <= rear; i++) {
                System.out.println(arr[i]);
            }
        }
    }
}
public class StackQueue {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack stack = new Stack(5);
        Queue queue = new Queue(5);
        System.out.println("---- Stack Operations ----");
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.display();
        stack.pop();
        stack.display();
        System.out.println("\n---- Queue Operations ----");
        queue.enqueue(100);
        queue.enqueue(200);
        queue.enqueue(300);
        queue.display();
        queue.dequeue();
        queue.display();
        sc.close();
    }
}