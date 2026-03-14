import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;

public class ReadFileExample  {

    public static void main(String[] args) {

        try {

            File file = new File("D:\\SEM--4\\Sample_tanvi.txt.txt");

            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);

            String line;

            while((line = br.readLine()) != null){
                System.out.println(line);
            }

            br.close();

        } catch(Exception e){
            System.out.println("Error reading file");
        }

    }
}