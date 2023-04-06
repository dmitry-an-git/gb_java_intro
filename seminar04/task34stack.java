
import java.util.Scanner;
import java.util.Stack;

public class task34stack {
    public static void main(String[] args) {
        Stack<String> st = new Stack<>(); 
        String str = AskForString();

        while (!str.equals("stop")) {
            switch (str) {
                case ("print"):
                    while (!st.isEmpty()) {
                        System.out.println(st.pop());
                    }
                    break;
                default: 
                    st.push(str);
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
