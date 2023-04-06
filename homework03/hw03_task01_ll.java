import java.io.File;
import java.io.FileWriter;
import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

// same mergesort but working with only one LinkedList during all iterations

public class hw03_task01_ll {
    public static void main(String[] args) {
        int size = AskForSize();
        LinkedList<Integer> myArray = CreateArray(size);
        StringToFile(myArray.toString());
        long start = System.currentTimeMillis();
        MergeSort(myArray,0,myArray.size());
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

    public static LinkedList<Integer> CreateArray(int size) {
        Random r = new Random();
        LinkedList<Integer> array = new LinkedList<>();
        for (int i = 0; i < size; i++) {
            array.add(r.nextInt(10,100));
        }
        return array;
    }

    public static void StringToFile(String str) {
        String fileName = "task01_ll.txt";
        // String fileFolder = "homework03";
        // String filePath = fileFolder + File.separator + fileName;
        if (str.length()>100) {}
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

    public static void MergeSort(LinkedList<Integer> array, int start, int size) {
        
        if (size == 1) { }
        else {
            int half = (size)/2; // 3 -> 1
            
            MergeSort(array,start,half); 
            MergeSort(array,start+half,size-half);
            int index_f = start; 
            int index_s = start+half; 
            int first_comp; 
            int second_comp; 
            int first_len = half;
            int second_len = size-half;

            while (true) {

                if (first_len == 0 || second_len == 0) { break; }
                else {
                    first_comp = array.get(index_f); 
                    second_comp = array.get(index_s); 

                    if (first_comp>second_comp) {
                        array.add(index_f, array.remove(index_s));
                        index_s++;
                        index_f++;
                        second_len--;
                    }
                    else {
                        index_f++;
                        first_len--;
                    }
                }
                
            }
            
            
        }
        
        
    }

}
