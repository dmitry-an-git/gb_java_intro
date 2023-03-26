package gb_java_intro.lecture01;

import java.io.FileReader;

public class filesReadCh {
    public static void main(String[] args) throws Exception{
        FileReader fr = new FileReader("file.txt");
        int c;
        while ((c = fr.read()) != -1) {
            char ch = (char) c;
            if (ch == '\n') {
                System.out.println();
            }
            else {
                System.out.print(ch);
            }
        }
    }
}