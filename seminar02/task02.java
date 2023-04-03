package gb_java_intro.seminar02;

import java.util.Scanner;

//  метод который сжимает строку
public class task02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.printf("Введите строку: ");
        String str = sc.next();
        //String str = "aaaabbbccd";
        // sc.close();

        // int counter = 1;
        // char prev = str.charAt(0);

        // for (int i = 1; i < str.length(); i++) {
        //     char curr = str.charAt(i);
            
        //     if (curr == prev) {
        //         counter ++;
        //     } else {
        //         System.out.printf("%c%d", prev, counter);
        //         counter = 1;
        //     }
        //     prev = str.charAt(i);
        // }

        // System.out.printf("%c%d\n", prev, counter);

        System.out.println(compressString(str));
    }

    public static String compressString(String str) {

        StringBuilder sb = new StringBuilder();

        int counter = 1;
        char prev = str.charAt(0);

        for (int i = 1; i < str.length(); i++) {
            char curr = str.charAt(i);
            
            if (curr == prev) {
                counter ++;
            } else {
                sb.append(prev).append(counter);
                counter = 1;
            }
            prev = str.charAt(i);
        }

        sb.append(prev).append(counter);
        return sb.toString();
    }
}
