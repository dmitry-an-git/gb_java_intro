import java.util.LinkedList;
import java.util.Random;

// Пусть дан LinkedList с несколькими элементами. 
// Реализуйте метод(не void), который вернет “перевернутый” список.

public class task01 {
    public static void main(String[] args) {
        int size = 10;
        LinkedList<Integer> ll = createLL(size);
        System.out.println(ll);
        LinkedList<Integer> reverse_ll = reverseLL(ll);
        System.out.println(reverse_ll);
    }

    public static LinkedList<Integer> createLL(int size) {
        LinkedList<Integer> ll = new LinkedList<>();
        Random r = new Random();
        for (int i = 0; i < size; i++) {
            ll.add(r.nextInt(10,100));
        }
        return ll;
    }

    public static LinkedList<Integer> reverseLL(LinkedList<Integer> lst) {
        
        LinkedList<Integer> reversed_ll = new LinkedList<>();
        while (!lst.isEmpty()) {
            reversed_ll.add(lst.removeLast());
        }
        return reversed_ll;
    }
}