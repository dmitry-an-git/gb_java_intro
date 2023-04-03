package gb_java_intro.lecture01;

import java.util.Random;
import java.util.Scanner;

public class task01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.printf("Enter the power of polynomial: ");
        int n = sc.nextInt();
        System.out.println(n);

        Random r = new Random();
        
        for (int index = 0; index < n; index++) {
            System.out.println(r.nextInt(0,100));
        }

        String pln = "";
        for (int index = 0; index < n; index++) {
            String mult = (str)r.nextInt(0,100);
            String power = (n-index);
            pln ++;
        }

    }
}
