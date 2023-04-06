import java.util.LinkedList;
import java.util.Random;
import java.util.Stack;

public class task01 {
    public static void main(String[] args) {
        int size = 10;
        LinkedList<Integer> ll = CreateLL(size);
        System.out.println(ll);
        LinkedList<Integer> reverse_ll = ReverseLL(ll);
        System.out.println(reverse_ll);
    }

    public static LinkedList<Integer> CreateLL(int size) {
        LinkedList<Integer> ll = new LinkedList<>();
        Random r = new Random();
        for (int i = 0; i < size; i++) {
            ll.add(r.nextInt(10,100));
        }
        return ll;
    }

    public static LinkedList<Integer> ReverseLL(LinkedList<Integer> lst) {
        
        LinkedList<Integer> reversed_ll = new LinkedList<>();
        while (!lst.isEmpty()) {
            reversed_ll.add(lst.removeLast());
        }
        return reversed_ll;
    }
}