
import java.util.LinkedList;
import java.util.Scanner;

public class task024 {
    public static void main(String[] args) {
        LinkedList<String> al = new LinkedList<>();
        String input = "";
        while (!input.equals("stop")) {
            input = AskForString();
            
            if (input.startsWith("print")) {
                String[] sa = input.split(":");
                try {
                    System.out.println(al.get(Integer.parseInt(sa[1])));
                } catch (Exception e) {
                    System.out.println("Wrong index");
                }
            }
            else if (input.equals("test")) {
                System.out.println(al);
            }
            else {
                al.add(input);
            }
        }
    }
    public static String AskForString() {
        Scanner sc = new Scanner(System.in);
        System.out.printf("Enter smth: ");
        String input = sc.nextLine().toLowerCase();
        //sc.close();
        return input;
    }
}
