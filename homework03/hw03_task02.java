import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class hw03_task02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.printf("Please set the size of the array: ");
        int size = sc.nextInt();
        sc.close();

        ArrayList<Integer> lst = fillArrayList(size);
        System.out.println(lst); 

        lst = RemoveEven(lst);
        System.out.println(lst);
    }

    public static ArrayList<Integer> fillArrayList(int size) {
        Random r = new Random();
        ArrayList<Integer> res = new ArrayList<>();
        for (int index = 0; index < size; index++) {
            res.add(r.nextInt(10));
        }
        return res;
    }

    public static ArrayList<Integer> RemoveEven(ArrayList<Integer> al) {
        for (int index = 0; index < al.size(); index++) {
            if (al.get(index) % 2 == 0 && al.get(index)>0) {
                al.remove(index);
                index--;
            }
        }
        return al;
    }
}
