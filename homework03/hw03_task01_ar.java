import java.io.File;
import java.io.FileWriter;
import java.util.Random;
import java.util.Scanner;

// MergeSort with creating of a new ArrayList at each iteration

public class hw03_task01_ar {
    public static void main(String[] args) {
        int size = AskForSize();
        int[] myArray = CreateArray(size);
        StringToFile(ArrayToString(myArray));
        long start = System.currentTimeMillis();
        myArray = MergeSort(myArray);
        long stop = System.currentTimeMillis();
        long time = stop-start;
        StringToFile(ArrayToString(myArray));
        StringToFile(String.format("size: %d\ntime: %d",size,(int)time));
        StringToFile("end");

    }

    public static String ArrayToString(int[] arr) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
            if (i != arr.length - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
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

    public static int[] CreateArray(int size) {
        Random r = new Random();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = r.nextInt(10,100);
        }
        return array;
    }

    public static void StringToFile(String str) {
        String fileName = "task01_ar.txt";
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

    public static int[] MergeSort(int[] array) {
        
        if (array.length == 1) {return array;}
        else {
            int half = array.length/2;
            
            int[] first = new int[half];
            for (int index = 0; index < half; index++) {
                first[index]=array[index];
            }

            int[] second = new int[array.length-half];
            for (int index = 0; index < array.length-half; index++) {
                second[index]=array[index+half];
            }
            
            first = MergeSort(first);
            second = MergeSort(second);

            int[] result = new int[array.length];
            
            int index_f = 0;
            int index_s = 0; 
            int first_comp = 0;
            int second_comp = 0;
            int step = 0;

            while (step < array.length) {

                if (index_f == first.length) { 
                    result[step] = second[index_s];
                    index_s++;
                }
                
                else if (index_s == second.length) { 
                    result[step] = first[index_f];
                    index_f++;
                }

                else {
                    first_comp = first[index_f]; 
                    second_comp = second[index_s]; 

                    if (first_comp>second_comp) {
                        result[step] = second_comp;
                        index_s++;
                    }
                    else {
                        result[step] = first_comp;
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
