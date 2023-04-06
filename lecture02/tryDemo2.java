

import java.io.File;

// same but checks if the file exists

public class tryDemo2 {
    public static void main(String[] args) {
        try {
            String pathProject = System.getProperty("user.dir");
            String pathFile = pathProject.concat("/file2.txt");
            File file = new File(pathFile);
            if (file.createNewFile()) {
                System.out.println("file created");
            } else {
                System.out.println("file existed");
            }
        } catch (Exception e) {
            System.out.println("catch");
        } 
        finally 
        {System.out.println("finally");}
}
}