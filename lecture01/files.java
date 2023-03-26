package gb_java_intro.lecture01;

import java.io.FileWriter;
import java.io.IOException;


// but it creates files in the root folder no tin the package folder

public class files {
    public static void main(String[] args) {
        try(FileWriter fw = new FileWriter("file.txt", false)) { 
            fw.write("line 1");
            fw.append("\n");
            fw.append("2");
            fw.append("\n");
            fw.write("line3");
            fw.flush();
        }
        catch(IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}

