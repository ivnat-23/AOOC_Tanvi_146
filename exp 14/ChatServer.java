import java.io.*;
import java.net.*;

public class ChatServer {

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(5000);
            System.out.println("Server started... Waiting for client");

            Socket socket = serverSocket.accept();
            System.out.println("Client connected!");

            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);

            // Thread for receiving messages
            Thread readThread = new Thread(() -> {
                try {
                    String msg;
                    while ((msg = input.readLine()) != null) {
                        System.out.println("Client: " + msg);
                    }
                } catch (IOException e) {
                    System.out.println("Connection closed.");
                }
            });

            // Thread for sending messages
            Thread writeThread = new Thread(() -> {
                try {
                    BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
                    String msg;
                    while ((msg = console.readLine()) != null) {
                        output.println(msg);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });

            readThread.start();
            writeThread.start();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}