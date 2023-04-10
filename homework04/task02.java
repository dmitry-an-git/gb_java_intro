import java.util.LinkedList;
import java.util.Random;

// Реализуйте очередь с помощью LinkedList со следующими методами:
// enqueue() - помещает элемент в конец очереди,
// dequeue() - возвращает первый элемент из очереди и удаляет его,
// first() - возвращает первый элемент из очереди, не удаляя.


public class task02 {
  public static void main(String[] args) {

    int size = 10;
    LinkedList<Integer> linkedList = createRandomList(size);
    System.out.println(linkedList);

    enqueue(linkedList,42);
    System.out.println(linkedList);

    int first = dequeue(linkedList);
    System.out.printf("First and deleted: %d\n", first);
    System.out.println(linkedList);

    first = first(linkedList);
    System.out.printf("First and still there: %d\n", first);
    System.out.println(linkedList);

  }

  public static LinkedList<Integer> createRandomList(int size) {
    Random r = new Random();
    LinkedList<Integer> newList = new LinkedList<>();
    for (int i = 0; i < size; i++) {
        newList.add(r.nextInt(10,100));
    }
    return newList;
  }  

  public static void enqueue(LinkedList<Integer> someList,int item) {
    someList.add(item);
  }

  public static int dequeue(LinkedList<Integer> someList) {
    return someList.removeFirst();
  }

  public static int first(LinkedList<Integer> someList) {
    return someList.getFirst();
  }
} 
