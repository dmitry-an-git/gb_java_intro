import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

// MergeSort with creating of a new ArrayList at each iteration

public class hw03_task01_al {
    public static void main(String[] args) {
        int size = AskForSize();
        ArrayList myArray = CreateArray(size);
        StringToFile(myArray.toString());
        long start = System.currentTimeMillis();
        myArray = MergeSort(myArray);
        long stop = System.currentTimeMillis();
        long time = stop-start;
        StringToFile(myArray.toString());
        StringToFile(String.format("size: %d\ntime: %d",size,(int)time));
        StringToFile("end");

    }

    public static int AskForSize() {
        Scanner sc = new Scanner(System.in);
        System.out.printf("Please set the size of the array: ");
        int size;
        try {
            size = sc.nextInt();
        } catch (Exception e) {
            System.out.println("Wrong input, try again.");
            size = AskForSize();
        }
        sc.close();
        return size;
    }

    public static ArrayList<Integer> CreateArray(int size) {
        Random r = new Random();
        ArrayList<Integer> array = new ArrayList<Integer>();
        for (int i = 0; i < size; i++) {
            array.add(r.nextInt(10,100));
        }
        return array;
    }

    public static void StringToFile(String str) {
        String fileName = "task01_al.txt";
        // String fileFolder = "homework03";
        // String filePath = fileFolder + File.separator + fileName;
        if (str.length()>50) {}
        else {
            try {
                // File f = new File(filePath);
                File f = new File(fileName);
                FileWriter fw = new FileWriter(f, true);
                fw.write(str);
                fw.write("\n");
                fw.flush();
                System.out.println(str);

            } catch (Exception e) {
                System.out.println("Oups");
            }
        }    
    }

    public static ArrayList<Integer> MergeSort(ArrayList<Integer> array) {
        
        if (array.size() == 1) {return array;}
        else {
            int half = array.size()/2;
            ArrayList<Integer> first = new ArrayList<>();

            for (int index = 0; index < half; index++) {
                first.add(array.get(index));
            }

            ArrayList<Integer> second = new ArrayList<>();
            for (int index = half; index < array.size(); index++) {
                second.add(array.get(index));
            }
            
            first = MergeSort(first);
            second = MergeSort(second);

            ArrayList<Integer> result = new ArrayList<>();
            
            int index_f = 0;
            int index_s = 0; 
            int first_comp = 0;
            int second_comp = 0;
            int step = 0;

            while (step < array.size()) {

                if (index_f == first.size()) { 
                    result.add(second.get(index_s));
                    index_s++;
                }
                
                else if (index_s == second.size()) { 
                    result.add(first.get(index_f));
                    index_f++;
                }

                else {
                    first_comp = first.get(index_f); 
                    second_comp = second.get(index_s); 

                    if (first_comp>second_comp) {
                        result.add(second_comp);
                        index_s++;
                    }
                    else {
                        result.add(first_comp);
                        index_f++;
                    }
                }
                step++; 
            }
            // System.out.println(result);
            return result;
        }
        
        
        
    }

}
