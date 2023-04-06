import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class task34deque {
    public static void main(String[] args) {
        Deque<String> dq = new ArrayDeque<>(); 
        String str = AskForString();

        while (!str.equals("stop")) {
            if (str.equals("print")) {
                while (!dq.isEmpty()) {
                    System.out.println(dq.pollFirst());
                }
            }
            else {
                dq.addFirst(str);
            }
            str = AskForString();
        }

    }
    public static String AskForString(){
        Scanner sc = new Scanner(System.in);
        System.out.printf("Enter smth: ");
        String res = sc.nextLine();
        return res;
    }
}
