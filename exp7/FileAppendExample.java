import java.io.*;
import java.util.Scanner;
public class FileAppendExample {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter file name: ");
            String fileName = sc.nextLine();
            File file = new File(fileName);
             // If file exists
            if(file.exists()) {
                System.out.println("File exists. Contents:");
                BufferedReader br = new BufferedReader(new FileReader(file));
                String line;
                while((line = br.readLine()) != null) {
                    System.out.println(line);
                }
                br.close();
                System.out.print("Do you want to add data to the end of the file? (Yes/No): ");
                String choice = sc.nextLine();
                if(choice.equalsIgnoreCase("Yes")) {
                    BufferedWriter bw = new BufferedWriter(new FileWriter(file, true));
                    System.out.println("Enter data (type 'exit' to stop):");
                    while(true) {
                        String data = sc.nextLine();
                        if(data.equalsIgnoreCase("exit"))
                            break;
                        bw.write(data);
                        bw.newLine();
                    }
                    bw.close();
                }

            }
            else {
                System.out.println("File does not exist. Creating new file.");
                BufferedWriter bw = new BufferedWriter(new FileWriter(file));
                System.out.println("Enter data (type 'exit' to stop):");
                while(true) {
                    String data = sc.nextLine();
                    if(data.equalsIgnoreCase("exit"))
                        break;
                     bw.write(data);
                    bw.newLine();
                }
                bw.close();
            }

        }
        catch(Exception e) {
            System.out.println("Error: " + e);
        }
    }
}