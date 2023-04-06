import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;



// MergeSort over ArrayList and LinkedList - comparison

public class hw03_task01_comp {
    public static void main(String[] args) {
        int size = AskForSize();
        int iter = 10;
        StringToFile(Compare(size,iter));
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
        String fileName = "task01_comp.txt";
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

    public static ArrayList<Integer> MergeSortAL(ArrayList<Integer> array) {
        
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
            
            first = MergeSortAL(first);
            second = MergeSortAL(second);

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

    public static void MergeSortLL(LinkedList<Integer> array, int start, int size) {
        
        if (size == 1) { }
        else {
            int half = (size)/2; // 3 -> 1
            
            MergeSortLL(array,start,half); 
            MergeSortLL(array,start+half,size-half);
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

    public static int RecordTime(Runnable expression) {
        long start = System.currentTimeMillis();
        expression.run();
        long stop = System.currentTimeMillis();
        long time = stop-start;
        return (int)time;
    }
    
    public static String Compare(int size, int iter) {
        
        int arrayTime = 0;
        int linkedTime = 0;
        int counter = iter;
        while (counter>0) {
            ArrayList<Integer> arrayList = CreateArray(size);
            StringToFile(arrayList.toString());

            LinkedList<Integer> linkedList = new LinkedList<>();
            linkedList.addAll(arrayList);
            
            arrayTime += RecordTime(() -> {MergeSortAL(arrayList);}); 
            //arrayList = MergeSortAL(arrayList); // we do this to amend the actual array
            //StringToFile(arrayList.toString());

            linkedTime += RecordTime(() -> {MergeSortLL(linkedList,0,linkedList.size());});
            StringToFile(linkedList.toString());

            counter--;
        }
        arrayTime = arrayTime/iter;
        linkedTime = linkedTime/iter;
        return String.format("Size: %d\nIterations: %d\nMergeSortAL time: %d\nMergeSortLL time: %d", 
                                     size, iter, arrayTime, linkedTime);
    }
}
