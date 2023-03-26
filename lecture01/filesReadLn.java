package gb_java_intro.lecture01;

import java.io.BufferedReader;
import java.io.FileReader;

public class filesReadLn {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new FileReader("file.txt"));
        String str;
        while ((str = br.readLine()) != null) {
            System.out.printf("== %s ==\n", str);
        }
        br.close();
    }
}
