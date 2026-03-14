import java.io.*;
import java.util.Scanner;
public class StudentFileExample {
public static void main(String[] args) {
try {
             Scanner sc = new Scanner(System.in);
             System.out.print("Enter Name: ");
            String name = sc.nextLine();
            System.out.print("Enter Age: ");
            int age = sc.nextInt();

            System.out.print("Enter Weight: ");
            float weight = sc.nextFloat();

            System.out.print("Enter Height: ");
            float height = sc.nextFloat();

            sc.nextLine(); // clear buffer

            System.out.print("Enter City: ");
            String city = sc.nextLine();

            System.out.print("Enter Phone Number: ");
            String phone = sc.nextLine();

            // Writing data to file
            FileOutputStream fos = new FileOutputStream("student.txt");
            DataOutputStream dos = new DataOutputStream(fos);

            dos.writeUTF(name);
            dos.writeInt(age);
            dos.writeFloat(weight);
            dos.writeFloat(height);
            dos.writeUTF(city);
            dos.writeUTF(phone);
            dos.close();
            System.out.println("\nData Stored Successfully!\n");
            // Reading data from file
            FileInputStream fis = new FileInputStream("student.txt");
            DataInputStream dis = new DataInputStream(fis);
            System.out.println("Student Information:");
            System.out.println("Name: " + dis.readUTF());
            System.out.println("Age: " + dis.readInt());
            System.out.println("Weight: " + dis.readFloat());
            System.out.println("Height: " + dis.readFloat());
            System.out.println("City: " + dis.readUTF());
            System.out.println("Phone: " + dis.readUTF());
            dis.close();
        }
        catch(Exception e) {
            System.out.println("Error: " + e);
        }

    }
}