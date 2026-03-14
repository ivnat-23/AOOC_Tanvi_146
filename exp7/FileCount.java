import java.io.*;
public class FileCount {
    public static void main(String[] args) {
        int vowelCount = 0;
        int wordCount = 0;
        int aCount = 0;
        try {
            FileReader fr = new FileReader("D:\\SEM--4\\Sample_tanvi.txt.txt");
            BufferedReader br = new BufferedReader(fr);
            String line;
            while((line = br.readLine()) != null) {
                // Count words
                String words[] = line.split(" ");
                wordCount += words.length;
                for(int i=0; i<line.length(); i++) {
                    char ch = Character.toLowerCase(line.charAt(i));
                    // Count vowels
                    if(ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u')
                        vowelCount++;
                    // Count 'a'
                    if(ch=='a')
                        aCount++;
                }
            }
            br.close();
            System.out.println("Total Vowels: " + vowelCount);
            System.out.println("Total Words: " + wordCount);
            System.out.println("Number of 'a': " + aCount);
        }
        catch(Exception e) {
            System.out.println("Error reading file");
        }
    }
}