package gb_java_intro.seminar02;

import java.util.Scanner;

// if pallindrome
public class task03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.printf("Введите строку: ");
        String str = sc.next();
        System.out.println(isP(str));

    }

    public static Boolean isP(String str) {
        int l = str.length();
        for (int index = 0; index < l/2; index++) {
            if (str.charAt(index)!=str.charAt(l-1-index)) {
                return false;
            }
        }
        
        return true;

    }
}
