import java.io.*;
import java.net.*;

public class SumServer {

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(6000);
            System.out.println("Server started... Waiting for client");

            Socket socket = serverSocket.accept();
            System.out.println("Client connected!");

            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

            // Receive numbers
            int num1 = dis.readInt();
            int num2 = dis.readInt();

            System.out.println("Received numbers: " + num1 + ", " + num2);

            // Calculate sum
            int sum = num1 + num2;

            // Send result back
            dos.writeInt(sum);

            System.out.println("Sum sent to client: " + sum);

            // Close connections
            dis.close();
            dos.close();
            socket.close();
            serverSocket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}