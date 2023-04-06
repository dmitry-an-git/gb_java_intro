

import java.util.*;

public class Ex003 {
    public static void main(String[] args) {
        Deque<Integer> deque = new ArrayDeque<>();
        
        deque.addFirst(1); 
        deque.addLast(2);
        System.out.println(deque);

        deque.removeLast(); 
        System.out.println(deque);

        deque.removeLast();
        System.out.println(deque);

        deque.offerFirst(13); // add
        deque.offerLast(22); // add
        System.out.println(deque);

        deque.pollFirst(); // remove
        deque.pollLast(); // remove
        System.out.println(deque); //empty

        deque.offerFirst(11); 
        deque.offerLast(2);
        System.out.println(deque);

        System.out.println(deque.getFirst());  // 11
        System.out.println(deque.getLast());   // 2
        
        System.out.println(deque.peekFirst()); // 11
        System.out.println(deque.peekLast());  // 2

        System.out.println(deque);
    }
}