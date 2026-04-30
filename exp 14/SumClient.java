import java.io.*;
import java.net.*;
import java.util.Scanner;

public class SumClient {

    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 6000);
            System.out.println("Connected to server");

            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
            DataInputStream dis = new DataInputStream(socket.getInputStream());

            Scanner sc = new Scanner(System.in);

            // Input numbers
            System.out.print("Enter first number: ");
            int num1 = sc.nextInt();

            System.out.print("Enter second number: ");
            int num2 = sc.nextInt();

            // Send to server
            dos.writeInt(num1);
            dos.writeInt(num2);

            // Receive result
            int result = dis.readInt();

            System.out.println("Sum received from server: " + result);

            // Close connections
            dos.close();
            dis.close();
            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}