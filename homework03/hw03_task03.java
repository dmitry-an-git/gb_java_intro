import java.io.File;
import java.io.FileWriter;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

// Задан целочисленный список ArrayList. Найти минимальное, максимальное и среднее ариф. из этого списка.

public class hw03_task03 {
    public static void main(String[] args) {
        int size = GetSize();
        ArrayList<Integer> lst = CreateArray(size);
        SaveAndDisplay(LocalTime.now());
        SaveAndDisplay(lst);
        SaveAndDisplay(Mean(lst));
        SaveAndDisplay(Min(lst));
        SaveAndDisplay(Max(lst));
        
    }
    
    public static int GetSize() {
        Scanner sc = new Scanner(System.in);
        System.out.printf("Set the size of the array: ");
        int size;
        try {
            size = sc.nextInt();
        } catch (Exception e) {
            System.out.println("Wrong input. Try again.");
            size = GetSize();
        }
        sc.close();
        return size;

    }

    public static ArrayList<Integer> CreateArray(int size) {
        Random r = new Random();
        ArrayList<Integer> myArrayList= new ArrayList<>();
        
        for (int i = 0; i < size; i++) {
            myArrayList.add(r.nextInt(10,100));
        }
        return myArrayList;
    }

    public static String Mean(ArrayList<Integer> lst) {
        int sum = 0;
        for (Integer item : lst) {
            sum += item;
        }

        float mean = (float) sum / lst.size();
        // System.out.printf("The mean is: %.2f\n", mean);
        return String.format("The mean is: %.2f", mean);
    } 
    
    public static String Max(ArrayList<Integer> lst) {
        int max = lst.get(0);
        for (Integer item : lst) {
            if (item>max) {max = item;}
        }
        // System.out.printf("The max is: %d\n", max);
        return String.format("The max is: %d", max);
    }

    public static String Min(ArrayList<Integer> lst) {
        int min = lst.get(0);
        for (Integer item : lst) {
            if (item<min) {min = item;}
        }
        // System.out.printf("The min is: %d\n", min);
        return String.format("The min is: %d", min);
    }

    public static void SaveAndDisplay(Object o) {
        String fileFolder = "homework03";
        String fileName = "task03.txt";
        String filePath = fileFolder + File.separator + fileName;
        File f = new File(filePath);
        try {
            FileWriter fw = new FileWriter(f,true);
            if (o instanceof ArrayList) {
                String str = o.toString();
                fw.write(str);
                fw.write("\n");
                System.out.println(str);
            }
            else if (o instanceof String) {
                fw.write(o.toString());
                fw.write("\n");
                System.out.println(o);
            }
            else if (o instanceof LocalTime) {
                fw.write("* * *\n");
                fw.write(o.toString());
                fw.write("\n");
                System.out.println(o);
            }
            fw.flush();

        } catch (Exception e) {
            System.out.println("Oups");
        }
        
    }

}
