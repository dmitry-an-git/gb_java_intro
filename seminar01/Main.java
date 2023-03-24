package gb_java_intro.seminar01;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("something");
        Scanner sc = new Scanner(System.in); // одна строчка на вскю программу, возможность считывать
        String sk = sc.nextLine();
        int age = sc.nextInt();
        System.out.println(sk);
        System.out.println(age);
        sc.close();
        
    }
}
