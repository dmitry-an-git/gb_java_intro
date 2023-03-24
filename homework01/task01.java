// Вычислить n-ое треугольного число(сумма чисел от 1 до n), а так же n! (произведение чисел от 1 до n)
// Ввод:5
// Треугольное число 1 + 2 + 3 + 4 + 5 = 15
// n! 1 * 2 * 3 * 4 * 5 = 120


package gb_java_intro.homework01;

import java.util.Scanner;

/**
 * task01
 */
public class task01 {
    public static void main(String[] args) {
    
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter an integer: ");
        int n = sc.nextInt();
        sc.close();

        float sum; int factor = 1;
        sum = (1+n) * n/2;
        System.out.printf("%d has a triangular number of %.0f\n", n, sum);

        for (int i = 1; i < n+1; i++) {
            factor *= i;
        }

        System.out.printf("It also has a factorial number of %d\n", factor);
    }

    
}