
import java.io.File;
import java.io.FileWriter;
import java.util.Random;

// task01: bubble sort + logger

public class task01 {
    public static void main(String[] args) {

        int n = 10; // i dont want to put it manually each time
        int[] myArr = fillArray(n);
        myArr = sortArray(myArr);

    }    

    public static int[] fillArray(int len) {
        int[] arr = new int[len];
        Random r = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = r.nextInt(0,10);
        }
        return arr;
    }

    public static String arrayToString(int[] arr) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]).append(" ");
        }
        return sb.toString();
    }

    public static int[] sortArray(int[] arr) {
   
        int temp;
        stringToFile("New run:");
        stringToFile(arrayToString(arr));
        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if (arr[j]<arr[i]) {
                    temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                    stringToFile(arrayToString(arr));
                }
            }
        }
        return arr;
    }

    public static void stringToFile(String str) { 
        // it both prints to the console and saves to the file
        String fileName = "task01_log.txt";
        String subFolderName = "homework02";
        String filePath = subFolderName + File.separator + fileName;
        File f = new File(filePath);
        
        try {
            FileWriter fw = new FileWriter(f,true);
            fw.write(str);
            fw.write("\n");
            fw.close();
            System.out.println(str);
        } catch (Exception e) {
            System.out.println("Oups");
        }

    }

}
