import java.util.ArrayList;
import java.util.LinkedList;


public class task01 {
    public static void main(String[] args) {
        int size = 1_000_000;

        ArrayList<Integer> al = CreateArrayList(size);
        LinkedList<Integer> ll = CreateLinkedList(size);

    }
    public static ArrayList<Integer> CreateArrayList(int size) {
        

        // long start = System.currentTimeMillis();

        ArrayList<Integer> al = new ArrayList<>(size);
        for (int index = 0; index < size; index++) {
            al.add(index);
        }
        long start = System.currentTimeMillis();
        al.add(0,1);
        long stop = System.currentTimeMillis();
        System.out.println(stop - start);

        return al;
    }
    public static LinkedList<Integer> CreateLinkedList(int size) {
        

        // long start = System.currentTimeMillis();

        LinkedList<Integer> ll = new LinkedList<>();
        for (int index = 0; index < size; index++) {
            ll.add(index);
        }

        long start = System.currentTimeMillis();
        ll.add(0,1);
        long stop = System.currentTimeMillis();
        System.out.println(stop - start);

        return ll;
    }
}
