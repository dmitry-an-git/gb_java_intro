package gb_java_intro.seminar02;

import java.io.File;
import java.io.FileWriter;

public class taskFile {
    public static void main(String[] args) {
        String fileFolder = "seminar02";
        String fileName = "/test_file.txt";
        String fullName = fileFolder + fileName;
        File file = new File(fullName);
        int n = 10;
        String text = "TEST";
        try {
            FileWriter fw = new FileWriter(file,false);
            for (int index = 0; index < n; index++) {
                fw.write(text);
                fw.write("\n");
            }
            fw.close();
            System.out.println("Gotcha");
        }
        catch (Exception e) {
            System.out.println("Smth went wrong");
        }
        
    }
}
