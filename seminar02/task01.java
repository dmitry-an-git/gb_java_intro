package gb_java_intro.seminar02;

import java.util.Scanner;

public class task01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.printf("Enter N: ");
        int n = sc.nextInt();
        System.out.printf("Enter the first char: ");
        String s1 = sc.next();
        System.out.printf("Enter the second char: ");
        String s2 = sc.next();
        sc.close();

        // for (int index = 0; index < n/2; index++) {

        //     System.out.printf(s1+s2);
        //     //System.out.printf(s2);
        // }

        StringBuilder sb = new StringBuilder();
        for (int index = 0; index < n/2; index++) {
            sb.append(s1).append(s2);
        }

        System.out.println(sb);
    }
}
